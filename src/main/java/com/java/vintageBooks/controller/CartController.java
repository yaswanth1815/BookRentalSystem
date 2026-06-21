package com.java.vintageBooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @PostMapping("/buyerscart")
    public String addingItemsToCart(){

    }
}
