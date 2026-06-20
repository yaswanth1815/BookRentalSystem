package com.java.vintageBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.vintageBooks.entity.Seller;
import com.java.vintageBooks.service.SellerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SellerAuthController {
    
    @Autowired
    private SellerService sellerService;

    @GetMapping("/sellersignin")
    public String signin(){
        return "sellersignin";
    }

    @GetMapping("/sellersignup")
    public String signup(){
        return "sellersignup";
    }

    @PostMapping("/sellersignup")
    public String sellerRegistration(Seller seller,Model model){
        if(sellerService.sellerExists(seller)){
            model.addAttribute("sellersignuperror","User Already Exists");
            return "sellersignup";
        }
        sellerService.saveSeller(seller);
        model.addAttribute("selleraddedsuccess","Seller Added Successfully");
        return "sellersignin";
    }

    @PostMapping("/sellersignin")
    public String sellerLogin(String username,String password,Model model,HttpSession session){
        Seller seller=sellerService.login(username,password);
        if(seller!= null){
            session.setAttribute("sellerobject", seller);
            return "sellerhome";
        }
        model.addAttribute("sellerloginerror","Invalid Credentials");
        return "sellersignin";
    }

}
