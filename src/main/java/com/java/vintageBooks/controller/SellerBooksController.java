package com.java.vintageBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.vintageBooks.entity.Seller;
import com.java.vintageBooks.entity.SellerBooks;
import com.java.vintageBooks.service.SellerBooksService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SellerBooksController {

    @Autowired
    private SellerBooksService sellerBooksService;

    @PostMapping("/sellingbook")
    public String AddingBook(SellerBooks currentSellerBook,HttpSession session, Model model){
        Seller seller=(Seller)session.getAttribute("sellerobject");
        SellerBooks sb=sellerBooksService.saveBook(currentSellerBook,seller);
        if(sb!=null){
            model.addAttribute("bookAddedMessage","Book Added Successfully");
        }
        else{
            model.addAttribute("bookAddedMessage","Something Went Wrong");
        }
        return "sellingbook";

    }
}
