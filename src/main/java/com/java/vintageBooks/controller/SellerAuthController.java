package com.java.vintageBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.vintageBooks.entity.Seller;
import com.java.vintageBooks.service.SellerService;

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
        return "sellersignin";
    }

    @PostMapping("/sellersignin")
    public String sellerLogin(String username,String password,Model model){
        if(sellerService.login(username,password) != null){
            return "sellerhome";
        }
        model.addAttribute("sellerloginerror","Invalid Credentials");
        return "sellersignin";
    }

}
