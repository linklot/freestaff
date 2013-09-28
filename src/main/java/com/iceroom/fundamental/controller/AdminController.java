package com.iceroom.fundamental.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.iceroom.fundamental.entity.Category;
import com.iceroom.fundamental.entity.PaginationWrapper;
import com.iceroom.fundamental.entity.Post;
import com.iceroom.fundamental.entity.User;
import com.iceroom.fundamental.service.IAccountService;
import com.iceroom.fundamental.service.IAdminService;
import com.iceroom.fundamental.viewmodel.CategoryViewModel;

/**
 * @author Lincoln
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Resource(name="iAccountService")
    private IAccountService accountService;
    
    @Resource(name="iAdminService")
    private IAdminService adminService;
    
    @RequestMapping(method=RequestMethod.GET)
    public String showIndex(Model model) {
        User user = accountService.getCurrentUser();
        model.addAttribute("user", user);
        return "adminIndex";
    }
    
    @RequestMapping(value="/newEmployer", method=RequestMethod.GET)
    public String showNewEmployer(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        User user = accountService.getCurrentUser();
        model.addAttribute("user", user);
        return "newEmployer";
    }
    
    @RequestMapping(value="/newEmployer", method=RequestMethod.POST)
    public String addNewEmployer(User user) {
        accountService.registerEmployer(user);
        return "redirect:/admin/newEmployer";
    }
    
    @RequestMapping(value="/pwd", method=RequestMethod.GET)
    public String showPWD(Model model,
            @RequestParam(value="r", defaultValue="") String result) {
        if(result.equals("y")) model.addAttribute("msg", "y");
        else if(result.equals("n")) model.addAttribute("msg", "n");
        User user = accountService.getCurrentUser();
        model.addAttribute("user", user);
        return "password";
    }
    
    @RequestMapping(value="/pwd", method=RequestMethod.POST)
    public String updatePWD(User user, @RequestParam("newPwd") String newPwd,
            @RequestParam("confirmPwd") String confirmPwd) {
        boolean result = accountService.changePwd(user.getId(), user.getPassword(), newPwd);
        if(result) return "redirect:/admin/pwd?r=y";
        else return "redirect:/admin/pwd?r=n";
    }
    
    @RequestMapping(value="/employers/{startIndex}/{pageSize}", method=RequestMethod.GET)
    public String showEmployers(@PathVariable Integer startIndex,
            @PathVariable Integer pageSize, Model model) {
        PaginationWrapper employerWrapper = adminService.getAllEmployers(startIndex, pageSize);
        model.addAttribute("empWrapper", employerWrapper);
        return "employers";
    }
    
    @RequestMapping(value="/employer/{id}", method=RequestMethod.GET)
    public String showEmployer(@PathVariable Long id, Model model) {
        User user = adminService.getEmployer(id.longValue());
        model.addAttribute("user", user);
        return "employer";
    }
    
    @RequestMapping(value="/employer", method=RequestMethod.POST)
    public String updateEmployer(User user) {
        adminService.updateEmployer(user);
        return "redirect:/admin/employer/" + user.getId();
    }
    
    @RequestMapping(value="/candidates/{startIndex}/{pageSize}", method=RequestMethod.GET)
    public String ListCandidates(@PathVariable Integer startIndex,
            @PathVariable Integer pageSize, Model model) {
        PaginationWrapper candWrapper = adminService.getAllCandidates(startIndex, pageSize);
        model.addAttribute("candWrapper", candWrapper);
        return "candidates";
    }
    
    @RequestMapping(value="/category", method=RequestMethod.GET)
    public String showAddCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        CategoryViewModel root_cate = adminService.getCategoryAndChildren(1);
        model.addAttribute("root_cate", root_cate);
        return "add_category";
    }
    
    @RequestMapping(value="/category", method=RequestMethod.POST)
    public String addCategory(Category category) {
        adminService.addCategory(category);
        return "redirect:/admin/category";
    }
    
    @RequestMapping(value="/categories", method=RequestMethod.GET)
    public String listCategories(Model model) {
        CategoryViewModel root_cate = adminService.getCategoryAndChildren(1);
        model.addAttribute("root_cate", root_cate);
        return "list_categories";
    }
    
    @RequestMapping(value="/post", method=RequestMethod.GET)
    public String preAddPost(Model model) {
        CategoryViewModel root_cate = adminService.getCategoryAndChildren(1);
        model.addAttribute("root_cate", root_cate);
        Post post = new Post();
        model.addAttribute("post", post);
        return "add_post";
    }
    
    @RequestMapping(value="/post/{id}", method=RequestMethod.GET)
    public String paraPreAddPost(Model model,
            @PathVariable Long id) {
        CategoryViewModel root_cate = adminService.getCategoryAndChildren(1);
        model.addAttribute("root_cate", root_cate);
        Post post = adminService.getPost(id.longValue());
        model.addAttribute("post", post);
        return "add_post";
    }
    
    @RequestMapping(value="/post", method=RequestMethod.POST)
    public String addPost(Post post,
            @RequestParam(value="miniPic") MultipartFile image) {
        try {
            if(post.getId() == 0) adminService.addPost(post, image);
            else {
                adminService.updatePost(post, image);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/admin/posts/0/20";
    }
    
    @RequestMapping(value="/posts/{startIndex}/{pageSize}", method=RequestMethod.GET)
    public String listPosts(Model model,
            @PathVariable Integer startIndex,
            @PathVariable Integer pageSize) {
        PaginationWrapper posts = adminService.getAllPosts(startIndex, pageSize);
        model.addAttribute("posts", posts);
        return "admin_list_posts";
    }
    
    @RequestMapping(value="/post/{id}/delete", method=RequestMethod.GET)
    public String deletePost(@PathVariable Long id) {
        adminService.deletePost(id.longValue());
        return "redirect:/admin/posts/0/20";
    }
    
    @RequestMapping(value="/postPics", method=RequestMethod.GET)
    public String managePic() {
        return "admin_postPics";
    }
    
    @RequestMapping(value="/ajaxGetPics", method=RequestMethod.GET)
    public @ResponseBody List<String> ajaxGetAllPics() {
        return adminService.getAllPostPics();
    }
    
    @RequestMapping(value="/ajaxUploadPic", method=RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    public void ajaxUploadPic(@RequestParam(value="image", required=true) MultipartFile image) {
        try {
            adminService.savePostPic(image);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param accountService the accountService to set
     */
    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * @param adminService the adminService to set
     */
    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

}
