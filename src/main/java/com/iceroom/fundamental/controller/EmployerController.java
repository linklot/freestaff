/**
 * 
 */
package com.iceroom.fundamental.controller;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iceroom.fundamental.entity.Classif;
import com.iceroom.fundamental.entity.Invitation;
import com.iceroom.fundamental.entity.User;
import com.iceroom.fundamental.service.IAccountService;
import com.iceroom.fundamental.service.IClassifService;
import com.iceroom.fundamental.service.IEmployerService;

/**
 * The Employer Controller
 * @author Lincoln
 *
 */
@Controller
@RequestMapping("/employer")
public class EmployerController {
    
    @Resource(name="iAccountService")
    private IAccountService accountService;
    
    @Resource(name="iEmployerService")
    private IEmployerService employerService;
    
    @Resource(name="iClassifService")
    private IClassifService classifService;
    
    @RequestMapping(method=RequestMethod.GET)
    public String showIndex(Model model) {
        User user = accountService.getCurrentUser();
        model.addAttribute("user", user);
        int candidateCount = employerService.getCandidateCount();
        model.addAttribute("candidateCount", candidateCount);
        int invitationCount = employerService.getInvitationCount(user.getEmployer().getId());
        model.addAttribute("invitationCount", invitationCount);
        return "employerIndex";
    }
    
    @RequestMapping(value="/profile", method=RequestMethod.GET)
    public String showProfile(Model model) {
        User user = accountService.getCurrentUser();
        model.addAttribute("user", user);
        return "empProfile";
    }
    
    @RequestMapping(value="/profile", method=RequestMethod.POST)
    public String saveProfiel(User user) {
        employerService.saveProfile(user);
        return "redirect:/employer/profile";
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String showSearch(Model model) {
        User user = accountService.getCurrentUser();
        List<Classif> classifs = classifService.getAllClassifs();
        model.addAttribute("user", user);
        model.addAttribute("classifs", classifs);
        return "empSearch";
    }
    
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String doSearch(@RequestParam("classif") long classifId,
            @RequestParam("sub-classif") long subClassifId,
            @RequestParam("keywords") String keywords,
            Model model) {
        Classif classif = null;
        
        /* c_k for criterion keywords, c_c for criterion classification,
         * c_s for criterion sub-classification */
        String c_k, c_c, c_s;
        
        if(keywords.equals("Key Words")) keywords = "";
        else keywords = keywords.toLowerCase();// All search keywords are in lowercase.
        
        if(keywords.equals("")) c_k = "";
        else c_k = keywords;
        
        if(classifId == 0) c_c = "";
        else {
            classif = employerService.getClassifById(classifId);
            c_c = classif.getName();
        }
        if(subClassifId == 0) c_s = "";
        else {
            classif = employerService.getClassifById(subClassifId);
            c_s = classif.getName();
        }
        
        model.addAttribute("c_k", c_k);
        model.addAttribute("c_c", c_c);
        model.addAttribute("c_s", c_s);
        List<User> cands = employerService.searchCandidates(keywords, c_c, c_s);
        model.addAttribute("candidates", cands);
        User user = accountService.getCurrentUser();
        model.addAttribute("user", user);
        return "searchResult";
    }
    
    @RequestMapping(value="/pwd", method=RequestMethod.GET)
    public String showPWD(Model model,
            @RequestParam(value="r", defaultValue="") String result) {
        if(result.equals("y")) model.addAttribute("msg", "y");
        else if(result.equals("n")) model.addAttribute("msg", "n");
        User user = accountService.getCurrentUser();
        model.addAttribute("user", user);
        return "emp_pwd";
    }
    
    @RequestMapping(value="/pwd", method=RequestMethod.POST)
    public String updatePWD(User user, @RequestParam("newPwd") String newPwd,
            @RequestParam("confirmPwd") String confirmPwd) {
        boolean result = accountService.changePwd(user.getId(), user.getPassword(), newPwd);
        if(result) return "redirect:/employer/pwd?r=y";
        else return "redirect:/employer/pwd?r=n";
    }
    
    @RequestMapping(value="candidate/{id}", method=RequestMethod.GET)
    public String showCandidate(@PathVariable long id,
            Model model) {
        User candidate = employerService.getCandidate(id);
        model.addAttribute("cand", candidate);
        User employer = accountService.getCurrentUser();
        model.addAttribute("user", employer);
        Invitation invi = employerService.getInvitationOfEmpCand(employer.getId(), candidate.getId());
        model.addAttribute("invitation", invi);
        return "candidate";
    }
    
    @RequestMapping(value="candidate/{id}", method=RequestMethod.POST)
    public String sendInvitation(@PathVariable long id, Model model) {
        User user = accountService.getCurrentUser();
        employerService.createInvitation(id, user);
        List<Invitation> invitations = employerService.getInvitationsOfEmployer(user);
        model.addAttribute("user", user);
        model.addAttribute("invitations", invitations);
        return "redirect:/employer/invitations";
    }
    
    @RequestMapping(value="invitations", method=RequestMethod.GET)
    public String showInvitations(Model model) {
        User user = accountService.getCurrentUser();
        List<Invitation> invitations = employerService.getInvitationsOfEmployer(user);
        model.addAttribute("user", user);
        model.addAttribute("invitations", invitations);
        return "emp_invitations";
    }
    
    @RequestMapping(value="/invitation/{id}/withdraw", method=RequestMethod.GET)
    public String withdrawInvitation(@PathVariable long id) {
        employerService.withdrawInvitation(id);
        return "redirect:/employer/invitations";
    }
    
    @RequestMapping(value="/invitation/{id}/resend", method=RequestMethod.GET)
    public String resendInvitation(@PathVariable long id) {
        employerService.resendInvitation(id);
        return "redirect:/employer/invitations";
    }
    
    @RequestMapping(value="/invitation/{id}/close", method=RequestMethod.GET)
    public String closeInvitation(@PathVariable long id) {
        employerService.closeInvitation(id);
        return "redirect:/employer/invitations";
    }
    
    @RequestMapping(value="/candCV/{id}", method=RequestMethod.GET)
    @ResponseBody
    public void downloadCandCV(@PathVariable long id,
            HttpServletResponse response) {
        try {
            File file = employerService.getCandCV(id);
            if(file != null) {
                InputStream is = (new FileSystemResource(employerService.getCandCV(id))).getInputStream();
                response.setContentType("application/pdf");
                IOUtils.copy(is, response.getOutputStream());
                response.flushBuffer();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @RequestMapping(value="/feedback", method=RequestMethod.GET)
    public String showFeedback() {
        return "empFeedback";
    }
    
    @RequestMapping(value="/feedback", method=RequestMethod.POST)
    @ResponseBody
    public void feedback(@RequestParam(value="content") String content) {
        employerService.saveFeedback(content);
    }

}
