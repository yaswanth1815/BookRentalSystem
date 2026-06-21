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

    
    public void deletePurchase(Integer id) {
        buyingRepository.deleteById(id);
    }
}