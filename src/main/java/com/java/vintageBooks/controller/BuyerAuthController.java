package com.java.vintageBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.java.vintageBooks.entity.Buyer;
import com.java.vintageBooks.service.BuyerService;

@Controller
public class BuyerAuthController {

    @GetMapping("/buyersignin")
    public String buyersignin(){
        return "buyersignin";
    }

    @GetMapping("/buyersignup")
    public String buyersignup(){
        return "buyersignup";
    }

    @Autowired
    private BuyerService buyerService;
    @PostMapping("/buyersignup")
    public String buyerSignup(Buyer buyer){
        if(buyerService.buyerExists(buyer)){
            return "buyersignup";
        }
        buyerService.saveBuyer(buyer);
        return "buyersignin";
    }

    @PostMapping("/buyersignin")
    public String buyerLogin(String username,String password){
        if(buyerService.buyerLogin(username,password)!=null){
            return "buyerhome";
        }
        return "buyersignin";
    }
}
