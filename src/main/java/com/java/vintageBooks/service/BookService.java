package com.java.vintageBooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.Book;
import com.java.vintageBooks.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }

    public List<Book> getBookByName(String name){
        return bookRepository.findByNameContaining(name);
    }

    public List<Book> getBookByAuthor(String author){
        return bookRepository.findByAuthorContaining(author);
    }

    public List<Book> getBookByType(String type){
        return bookRepository.findByType(type);
    }
}
