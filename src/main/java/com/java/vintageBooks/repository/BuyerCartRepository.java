package com.java.vintageBooks.repository;

import com.java.vintageBooks.entity.BuyerCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyerCartRepository extends JpaRepository<BuyerCart, Integer> {

    List<BuyerCart> findByUsername(String username);
    List<BuyerCart> findByNameContaining(String name);

}
