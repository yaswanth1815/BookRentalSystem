package com.java.vintageBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.java.vintageBooks.entity.SellerBooks;
import com.java.vintageBooks.service.SellerBooksService;

@Controller
public class SellerBooksController {

    @Autowired
    private SellerBooksService sellerBooksService;

    @PostMapping("/sellingbook")
    public String AddingBook(SellerBooks currentSellerBook){
        sellerBooksService.
    }
}
