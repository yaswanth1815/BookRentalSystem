package com.java.vintageBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import com.java.vintageBooks.entity.Queries;
import com.java.vintageBooks.service.BuyerQueriesService;

@Controller
public class BuyerFieldsController{

    @Autowired
    private BuyerQueriesService buyerQueryService;

   @PostMapping("/buyerquery")
   public String buyerSendingQuery(Queries buyerquery,Model model){

        buyerquery.setUsertype("Buyer");
        Queries query=buyerQueryService.saveBuyerQuery(buyerquery);
        if(query!=null){
            model.addAttribute("buyerStatus","Message Sent Successfully");
        }
        else{
            model.addAttribute("buyerStatus","Something Went Wrong");
        }
        return "buyercontactus";
   }
}