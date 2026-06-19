package com.java.vintageBooks.service;

import com.java.vintageBooks.entity.Seller;
import com.java.vintageBooks.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository userRepository;

    public Seller saveSeller(Seller seller) {
        return userRepository.save(seller);
    }

    public Seller login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    public boolean sellerExists(Seller seller) {
        return userRepository.existsByUsername(seller.getUsername());
    }

    public Seller getSeller(String username) {
        return userRepository.findByUsername(username);
    }
}