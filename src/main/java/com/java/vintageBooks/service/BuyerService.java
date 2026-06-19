package com.java.vintageBooks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.Buyer;
import com.java.vintageBooks.repository.BuyerRepository;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public Buyer saveBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public Buyer buyerLogin(String username, String password) {
        return buyerRepository.findByUsernameAndPassword(username,password);
    }

    public boolean buyerExists(Buyer buyer) {
        return buyerRepository.existsByUsername(buyer.getUsername());
    }

    public Buyer getBuyer(String username) {
        return buyerRepository.findByUsername(username);
    }
}