package com.java.vintageBooks.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.java.vintageBooks.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{
    List<Book> findByNameContaining(String name);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByType(String type);
}
