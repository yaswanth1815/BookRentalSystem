package com.java.vintageBooks.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.java.vintageBooks.entity.SellerBooks;

public interface SellerBooksRepository extends JpaRepository<SellerBooks,Integer>{
    SellerBooks findByBooknameAndAuthorAndSaletype(String bookname, String author, String saletype);
    List<SellerBooks> findByBooknameContaining(String bookname);
    List<SellerBooks> findByAuthorContaining(String author);
    List<SellerBooks> findBySaletype(String saletype);
}
