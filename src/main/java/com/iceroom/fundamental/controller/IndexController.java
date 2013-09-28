package com.iceroom.fundamental.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iceroom.fundamental.entity.Classif;
import com.iceroom.fundamental.service.IAccountService;
import com.iceroom.fundamental.service.IClassifService;
import com.iceroom.fundamental.service.IEmailService;
import com.iceroom.fundamental.service.IGeneralService;
import com.iceroom.fundamental.viewmodel.ClassifViewModel;

/**
 * The cover page Controller.
 * @author Lincoln
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
    
    @Resource(name="iAccountService")
    private IAccountService accountService;
    
    @Resource(name="iClassifService")
    private IClassifService classifService;
    
    @Resource(name="iGeneralService")
    private IGeneralService generalService;
    
    @Resource(name="iEmailService")
    private IEmailService emailService;

    @RequestMapping(method=RequestMethod.GET)
    public String showIndex() {
        return "index";
    }
    
    @RequestMapping(value="login", method=RequestMethod.GET)
    public String showLogin() {
        return "login";
    }
    
    @RequestMapping(value="404", method=RequestMethod.GET)
    public String show404() {
        return "error404";
    }
    
    @RequestMapping(value="500", method=RequestMethod.GET)
    public String show500() {
        return "error500";
    }
    
    @RequestMapping(value="403", method=RequestMethod.GET)
    public String show403() {
        return "error403";
    }
    
    /**
     * Show register page
     * @return
     */
    @RequestMapping(value="reg", method=RequestMethod.GET)
    public String showReg() {
        return "reg";
    }
    
    @RequestMapping(value="reg", method=RequestMethod.POST)
    public String executeReg(
            @RequestParam("firstname") String firstName,
            @RequestParam("lastname") String lastName,
            @RequestParam("email") String email,
            @RequestParam("pwd") String password,
            @RequestParam("repwd") String rePassword) {
        
        /* Register a new candidate account. */
        String account = accountService.registerCandidate(firstName, lastName, email, rePassword);
        
        return "redirect:regConfirm?account=" + account;
    }
    
    @RequestMapping(value="regConfirm", method=RequestMethod.GET)
    public String regConfirm(@RequestParam("account") String account,
            Model model) {
        model.addAttribute("account", account);
        return "regConfirm";
    }
    
    /**
     * Get all sub-classifications of a parent classification.
     * @param id The id of the parent classification.
     * @return List<{@link Classif}>
     */
    @RequestMapping(value="classif/{id}/sub", method=RequestMethod.GET)
    public @ResponseBody List<ClassifViewModel> ajaxGetSubClassifs(@PathVariable long id) {
        List<Classif> subs = classifService.getSubClassifs(id);
        List<ClassifViewModel> list = new ArrayList<ClassifViewModel>();
        
        for(Classif c : subs) {
            ClassifViewModel viewModel = new ClassifViewModel(c.getId(), c.getName());
            list.add(viewModel);
        }
        return list;
    }
    
    @RequestMapping(value="login/err", method=RequestMethod.GET)
    public String showLoginError() {
        return "loginErr";
    }
    
    @RequestMapping(value="/about", method=RequestMethod.GET)
    public String showAbout(Model model) {
        model.addAttribute("post", generalService.getPostAbout());
        return "about";
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
