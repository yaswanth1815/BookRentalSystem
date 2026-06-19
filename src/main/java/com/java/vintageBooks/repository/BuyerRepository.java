package com.java.vintageBooks.repository;

import com.java.vintageBooks.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, String> {

    Buyer findByUsername(String username);
    Buyer findByUsernameAndPassword(String username,String password);
    boolean existsByUsername(String username);
}
