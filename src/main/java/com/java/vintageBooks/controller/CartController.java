package com.java.vintageBooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.vintageBooks.entity.Buyer;
import com.java.vintageBooks.entity.BuyerCart;
import com.java.vintageBooks.entity.SellerBooks;
import com.java.vintageBooks.service.BuyerCartService;
import com.java.vintageBooks.service.SellerBooksService;
import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

    @Autowired
    private SellerBooksService sellerBooksService;
    @Autowired
    private BuyerCartService buyerCartService;

    @PostMapping("/buyerscart")
    public String addToCart(@RequestParam Integer bookid,HttpSession session,RedirectAttributes reDirectAttributes){

        Buyer buyer=(Buyer) session.getAttribute("buyerobject");
        SellerBooks currentBook=sellerBooksService.getBookById(bookid).orElseThrow(() -> new RuntimeException("Book not found!"));
        try{
            buyerCartService.addToCart(buyer.getUsername(),currentBook);
            reDirectAttributes.addFlashAttribute("messagebookid",currentBook.getId());
            reDirectAttributes.addFlashAttribute("redirectedmessage","Added");
        }
        catch(Exception e){
            reDirectAttributes.addFlashAttribute("messagebookid",currentBook.getId());
            reDirectAttributes.addFlashAttribute("redirectedmessage","No Stock");
        }
        
        return "redirect:/buyingbook";
    }

    @PostMapping("/buyerscart")
    public String showInCart(HttpSession session){
        Buyer buyer=(Buyer) session.getAttribute("buyerobject");
        List<BuyerCart> buyerCart=buyerCartService.getCartByUsername(buyer.getUsername());
        b
        return "buyercart";
    }
}
