package com.java.vintageBooks.repository;

import com.java.vintageBooks.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, String> {

    Seller findByUsername(String username);
    Seller findByUsernameAndPassword(String username,String password);
    boolean existsByUsername(String username);
}