package com.java.vintageBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.java.vintageBooks.entity.Buyer;
import com.java.vintageBooks.service.BuyerService;

import jakarta.servlet.http.HttpSession;

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

    @GetMapping("/buyershome")
    public String buyerHome(){
        return "buyerhome";
    }

    @GetMapping("/buyersbuyingabook")
    public String buyABook(){
        return "buyingbook";
    }

    @GetMapping("/buyersvintagebooks")
    public String vintageBook(){
        return "vintagebooks";
    }

    @GetMapping("/buyerscontactus")
    public String buyerContactUs(){
        return "buyercontactus";
    }

    @GetMapping("/buyerscart")
    public String buyerCart(){
        return "buyercart";
    }

    @GetMapping("/buyersprofile")
    public String buyerProfile(){
        return "buyerprofile";
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
        model.addAttribute("buyeraddedsuccess","Buyer Added Successfully");
        return "buyersignin";
    }

    @PostMapping("/buyersignin")
    public String buyerLogin(String username,String password,Model model,HttpSession session){
        
        Buyer buyer=buyerService.buyerLogin(username, password);
        if(buyer!=null){
            session.setAttribute("buyerobject",buyer);
            return "buyerhome";
        }
        model.addAttribute("buyersigninerror","Invalid Credentials");
        return "buyersignin";
    }
}
