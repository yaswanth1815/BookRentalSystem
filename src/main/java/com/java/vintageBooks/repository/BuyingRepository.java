package com.java.vintageBooks.repository;

import com.java.vintageBooks.entity.Buying;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BuyingRepository extends JpaRepository<Buying, Integer> {

    List<Buying> findByUsername(String username);
    List<Buying> findBySeller(String seller);
    List<Buying> findByBookNameContaining(String name);
}