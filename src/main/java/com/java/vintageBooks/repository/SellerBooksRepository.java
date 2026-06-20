package com.java.vintageBooks.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.java.vintageBooks.entity.SellerBooks;

public interface SellerBooksRepository extends JpaRepository<SellerBooks,Integer>{
    SellerBooks findByNameAndAuthorAndType(String name, String author, String type);
    List<SellerBooks> findByNameContaining(String name);
    List<SellerBooks> findByAuthorContaining(String author);
    List<SellerBooks> findByType(String type);
}
