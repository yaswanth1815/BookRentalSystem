package com.java.vintageBooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.Buying;
import com.java.vintageBooks.repository.BuyingRepository;

@Service
public class BuyingService {

    @Autowired
    private BuyingRepository buyingRepository;

    public Buying saveBuying(Buying buying) {
        return buyingRepository.save(buying);
    }

    public List<Buying> getAllPurchases() {
        return buyingRepository.findAll();
    }

    public List<Buying> getPurchasesByUsername(String username) {
        return buyingRepository.findByUsername(username);
    }

    public List<Buying> getPurchasesBySeller(String seller) {
        return buyingRepository.findBySeller(seller);
    }

    public Buying getPurchaseById(Integer id) {
        return buyingRepository.findById(id).orElse(null);
    }

    public void deletePurchase(Integer id) {
        buyingRepository.deleteById(id);
    }
}