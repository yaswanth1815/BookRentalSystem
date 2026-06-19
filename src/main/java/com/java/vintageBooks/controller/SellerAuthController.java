package com.java.vintageBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String sellerRegistration(Seller seller){
        if(sellerService.sellerExists(seller)){
            return "sellersignup";
        }
        sellerService.saveSeller(seller);
        return "sellersignin";
    }

    @PostMapping("/sellersignin")
    public String sellerLogin(String username,String password){
        if(sellerService.login(username,password) != null){
            return "sellerhome";
        }
        return "sellersignin";
    }

}
