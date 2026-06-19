package com.java.vintageBooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.BuyerCart;
import com.java.vintageBooks.repository.BuyerCartRepository;

@Service
public class BuyerCartService {

    @Autowired
    private BuyerCartRepository buyerCartRepository;

    public BuyerCart saveCartItem(BuyerCart buyerCart) {
        return buyerCartRepository.save(buyerCart);
    }

    public List<BuyerCart> getCartByUsername(String username) {
        return buyerCartRepository.findByUsername(username);
    }

    public List<BuyerCart> getAllCartItems() {
        return buyerCartRepository.findAll();
    }

    public BuyerCart getCartItemById(Integer id) {
        return buyerCartRepository.findById(id).orElse(null);
    }

    public void deleteCartItem(Integer id) {
        buyerCartRepository.deleteById(id);
    }
}