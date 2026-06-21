package com.java.vintageBooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.ShowAllBooks;
import com.java.vintageBooks.repository.ShowAllBooksRepository;

@Service
public class ShowAllBooksService {

    @Autowired
    private ShowAllBooksRepository showAllBooksRepository;
    public List<ShowAllBooks> showAllBooks(){
        return showAllBooksRepository.findAll();
    }
}