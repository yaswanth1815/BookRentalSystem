package com.java.vintageBooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.SellerBooks;
import com.java.vintageBooks.repository.SellerBooksRepository;

@Service
public class SellerBooksService {
    @Autowired
    private SellerBooksRepository bookRepository;
    
    public SellerBooks saveBook(SellerBooks book){
        return bookRepository.save(book);
    }

    public List<SellerBooks> getAllBooks(){
        return bookRepository.findAll();
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }

    public List<SellerBooks> getBookByName(String name){
        return bookRepository.findByNameContaining(name);
    }

    public List<SellerBooks> getBookByAuthor(String author){
        return bookRepository.findByAuthorContaining(author);
    }

    public List<SellerBooks> getBookByType(String type){
        return bookRepository.findByType(type);
    }
}
