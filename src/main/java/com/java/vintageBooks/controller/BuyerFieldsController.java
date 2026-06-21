package com.java.vintageBooks.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.java.vintageBooks.entity.Queries;
import com.java.vintageBooks.entity.ShowAllBooks;
import com.java.vintageBooks.service.BuyerQueriesService;
import com.java.vintageBooks.service.ShowAllBooksService;

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

       @Autowired
    private ShowAllBooksService showAllBooksService;

    @GetMapping("/buyingbook")
    public String getListOfAllBooks(Model model){
      List<ShowAllBooks> booksList=showAllBooksService.showAllBooks();
      model.addAttribute("booklist", booksList);
      return "buyingbook";
   }

  
}