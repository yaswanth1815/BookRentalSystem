package com.java.vintageBooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.vintageBooks.entity.Seller;
import com.java.vintageBooks.entity.SellerBooks;
import com.java.vintageBooks.service.SellerBooksService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @Autowired
    private SellerBooksService sellerBooksService;

    @GetMapping("/sellerprofile")
    public String sellerProfile(HttpSession session,Model model){
        Seller currSeller=(Seller) session.getAttribute("sellerobject");
        List<SellerBooks> sellerBooksList=sellerBooksService.getSellerBooksbySellerusername(currSeller.getUsername());
        Integer countOfRows=sellerBooksList.size();
        Integer quant=0;
        Integer quantRem=0;
        for(SellerBooks sb:sellerBooksList){
            quant+=Integer.parseInt(sb.getQuantity());
            quantRem+=Integer.parseInt(sb.getQuantityremaining());
        }
        model.addAttribute("countOfRows",countOfRows);
        model.addAttribute("quantity",quant);
        model.addAttribute("remaining",quantRem);
        model.addAttribute("listOfSellerBooks",sellerBooksList);
        
        return "sellerprofile";
    }
}
