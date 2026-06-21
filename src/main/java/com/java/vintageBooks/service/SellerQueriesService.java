package com.java.vintageBooks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.Queries;
import com.java.vintageBooks.repository.SellerQueriesRepository;

@Service
public class SellerQueriesService {
    
    @Autowired
    private SellerQueriesRepository sellerQueriesRepository;

    public Queries storeData(Queries query){
        return sellerQueriesRepository.save(query);
    }
}