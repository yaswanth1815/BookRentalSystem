package com.java.vintageBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.vintageBooks.entity.Admins;
import com.java.vintageBooks.service.AdminService;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService; 

    @GetMapping("/adminsigninpage")
    public String adminSigninPage(){
        return "adminsignin";
    }

    @PostMapping("/adminsignin")
    public String AdminLogin(String adminname,String adminpassword,Model model){
        Admins admins=adminService.checkAdmin(adminname,adminpassword);
        if(admins!=null){
            return "adminhome";
        }
        model.addAttribute("errormessage","Invalid Credentials");
        return "adminsignin";
    }

}
