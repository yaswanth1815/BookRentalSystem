package com.java.vintageBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String buyerSignup(Buyer buyer,Model model){
        if(buyerService.buyerExists(buyer)){
            model.addAttribute("error","User Already Exists");
            return "buyersignup";
        }
        buyerService.saveBuyer(buyer);
        return "buyersignin";
    }

    @PostMapping("/buyersignin")
    public String buyerLogin(String username,String password,Model model){
        if(buyerService.buyerLogin(username,password)!=null){
            return "buyerhome";
        }
        model.addAttribute("error","Invalid Credentials");
        return "buyersignin";
    }
}
