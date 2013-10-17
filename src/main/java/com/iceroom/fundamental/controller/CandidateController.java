package com.iceroom.fundamental.controller;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.iceroom.fundamental.entity.Classif;
import com.iceroom.fundamental.entity.EduHistory;
import com.iceroom.fundamental.entity.EmpHistory;
import com.iceroom.fundamental.entity.Employer;
import com.iceroom.fundamental.entity.Invitation;
import com.iceroom.fundamental.entity.User;
import com.iceroom.fundamental.service.IAccountService;
import com.iceroom.fundamental.service.ICandidateService;
import com.iceroom.fundamental.service.IClassifService;
import com.iceroom.fundamental.viewmodel.CandidateViewModel;

/**
 * Candidate controller
 * @author Lincoln
 *
 */
@Controller
@RequestMapping("/candidate")
public class CandidateController {
    
    @Resource(name="iAccountService")
    private IAccountService accountService;
    
    @Resource(name="iCandidateService")
    private ICandidateService candidateService;
    
    @Resource(name="iClassifService")
    private IClassifService classifService;
    
    @RequestMapping(method=RequestMethod.GET)
    public String showIndex(Model model) {
        User user = accountService.getCurrentCandidate();
        if(user.getCandidate().getPicUrl().equals(""))
            user.getCandidate().setPicUrl("/res/image/default_avatar.png");
        model.addAttribute("user", user);
        int inviCount = candidateService.getNewInvitationCount(user.getId());
        model.addAttribute("inviCount", inviCount);
        return "candidateIndex";
    }
    
    @RequestMapping(value="/editAvatar", method=RequestMethod.GET)
    public String showEditAvatar(Model model) {
        User user = accountService.getCurrentCandidate();
        if(user.getCandidate().getPicUrl().equals(""))
            user.getCandidate().setPicUrl("/res/image/default_avatar.png");
        model.addAttribute("user", user);
        return "editAvatar";
    }
    
    @RequestMapping(value="/editAvatar", method=RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    public void uploadAvatar(@RequestParam("cid") long id,
            @RequestParam(value="pic_file") MultipartFile image) {
        try {
            candidateService.updateAvatar(id, image);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @RequestMapping(value="/avatar/{id}", method=RequestMethod.GET)
    public @ResponseBody String ajaxGetAvatar(@PathVariable long id) {
        return candidateService.getAvatarPath(id);
    }
    
    @RequestMapping(value="/classif", method=RequestMethod.GET)
    public String editClassif(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        List<Classif> classifs = classifService.getAllClassifs();
        model.addAttribute("classifs", classifs);
        return "editClassif";
    }
    
    @RequestMapping(value="/classif", method=RequestMethod.POST)
    public String updateClassif(User user,
            @RequestParam(value="classif") long classifId,
            @RequestParam(value="subClassif") long subClassifId) {
        
        candidateService.saveClassif(user, classifId, subClassifId);
        
        return "redirect:/candidate/classif";
    }
    
    @RequestMapping(value="/ielts", method=RequestMethod.GET)
    public String editIelts(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        return "editIelts";
    }
    
    @RequestMapping(value="/ielts", method=RequestMethod.POST)
    public String updateIelts(User user) {
        candidateService.saveIelts(user);
        return "redirect:/candidate/ielts";
    }
    
    @RequestMapping(value="/keySkills", method=RequestMethod.GET)
    public String editKeySkills(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        return "editKeySkills";
    }
    
    @RequestMapping(value="/keySkills", method=RequestMethod.POST)
    public String updateSkills(User user) {
        candidateService.saveKeySkills(user);
        return "redirect:/candidate/keySkills";
    }
    
    @RequestMapping(value="/skillAssess", method=RequestMethod.GET)
    public String editSkillAssess(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        return "editSkillAssess";
    }
    
    @RequestMapping(value="/skillAssess", method=RequestMethod.POST)
    public String updateSkillAssess(User user) {
        candidateService.saveSkillAssess(user);
        return "redirect:/candidate/skillAssess";
    }
    
    @RequestMapping(value="/pitch", method=RequestMethod.GET)
    public String editPitch(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        return "editPitch";
    }
    
    @RequestMapping(value="/pitch", method=RequestMethod.POST)
    public String updatePitch(User user) {
        candidateService.savePitch(user);
        return "redirect:/candidate/pitch";
    }
    
    @RequestMapping(value="/empHistory", method=RequestMethod.GET)
    public String showEmpHistory(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        List<EmpHistory> empHistories = candidateService.getUserEmpHistories(user);
        model.addAttribute("empHistories", empHistories);
        return "empHistory";
    }
    
    @RequestMapping(value="/empHistory", method=RequestMethod.POST)
    public String updateEmpHistory(@ModelAttribute("candidate") CandidateViewModel candidateModel) {
        List<EmpHistory> histories = candidateModel.getEmpHistories();
        User user = accountService.getCurrentCandidate();
        candidateService.saveEmpHistory(user, histories);
        return "redirect:/candidate/empHistory";
    }
    
    @RequestMapping(value="/eduHistory", method=RequestMethod.GET)
    public String showEduHistory(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        List<EduHistory> eduHistories = candidateService.getUserEduHistories(user);
        model.addAttribute("eduHistories", eduHistories);
        return "eduHistory";
    }
    
    @RequestMapping(value="/eduHistory", method=RequestMethod.POST)
    public String updateEduHistory(@ModelAttribute("candidate") CandidateViewModel candidateModel) {
        List<EduHistory> histories = candidateModel.getEduHistories();
        User user = accountService.getCurrentCandidate();
        candidateService.saveEduHistory(user, histories);
        return "redirect:/candidate/eduHistory";
    }
    
    @RequestMapping(value="/interests", method=RequestMethod.GET)
    public String showInterests(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        return "interests";
    }
    
    @RequestMapping(value="/interests", method=RequestMethod.POST)
    public String updateInterests(User user) {
        candidateService.saveInterests(user);
        return "redirect:/candidate/interests";
    }
    
    @RequestMapping(value="/pwd", method=RequestMethod.GET)
    public String showPwdPage(Model model,
            @RequestParam(value="err", defaultValue="") String err) {
        if(err.equals("y")) model.addAttribute("msg", "n");
        else if(err.equals("n")) model.addAttribute("msg", "y");
        
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        return "pwd";
    }
    
    @RequestMapping(value="/pwd", method=RequestMethod.POST)
    public String updatePassword(User user,
            @RequestParam(value="n_pwd") String newPwd,
            @RequestParam(value="c_pwd") String confirmPwd) {
        boolean valid = false;
        if(newPwd.equals(confirmPwd)) {
            valid = accountService.changePwd(user.getId(), user.getPassword(), newPwd);
        } else valid = false;
        
        if(!valid) return "redirect:/candidate/pwd?err=y";
        else return "redirect:/candidate/pwd?err=n";
    }
    
    @RequestMapping(value="/cv", method=RequestMethod.GET)
    public String showCV(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        return "cv";
    }
    
    @RequestMapping(value="/cv", method=RequestMethod.POST)
    public String updateCV(User user,
            @RequestParam(value="cvFile") MultipartFile cvFile) {
        try {
            candidateService.saveCV(user, cvFile);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/candidate/cv";
    }
    
    @RequestMapping(value="/downloadcv", method=RequestMethod.GET)
    @ResponseBody
    public void downloadCV(HttpServletResponse response) {
        try {
            User user = accountService.getCurrentCandidate();
            InputStream is = (new FileSystemResource(candidateService.getCVFile(user))).getInputStream();
            response.setContentType("application/pdf");
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @RequestMapping(value="/invitations", method=RequestMethod.GET)
    public String viewInvitations(Model model) {
        User user = accountService.getCurrentCandidate();
        List<Invitation> invitations = candidateService.getInvitations(user.getId());
        
        model.addAttribute("user", user);
        model.addAttribute("invitations", invitations);
        return "cand_invi";
    }
    
    @RequestMapping(value="/invitation/{id}/{action}", method=RequestMethod.GET)
    public String actionOnInvitation(@PathVariable long id,
            @PathVariable String action) {
        if(action.equals("accept")) candidateService.acceptInvitation(id);
        else if(action.equals("decline")) candidateService.declineInvitation(id);
        return "redirect:/candidate/invitations";
    }
    
    @RequestMapping(value="/invitation/{id}/employer", method=RequestMethod.GET)
    public String viewEmployer(@PathVariable long id, Model model) {
        Employer employer = candidateService.getEmployerByInvitation(id);
        model.addAttribute("employer", employer);
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        return "employerProfile";
    }
    
    @RequestMapping(value="/member", method=RequestMethod.GET)
    public String showMembership(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        return "membership";
    }
    
    @RequestMapping(value="/paymentHistory", method=RequestMethod.GET)
    public String showPayment(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        return "paymentHistory";
    }
    
    @RequestMapping(value="/nameEmail", method=RequestMethod.GET)
    public String showNameEmail(Model model) {
        User user = accountService.getCurrentCandidate();
        model.addAttribute("user", user);
        return "candNameEmail";
    }
    
    @RequestMapping(value="/nameEmail", method=RequestMethod.POST)
    public String updateNameEmail(User user) {
        candidateService.updateCandidateNameEmail(user);
        return "redirect:/candidate";
    }

    /**
     * @param accountService the accountService to set
     */
    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * @param classifService the classifService to set
     */
    public void setClassifService(IClassifService classifService) {
        this.classifService = classifService;
    }

}
