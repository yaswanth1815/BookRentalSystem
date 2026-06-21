package com.java.vintageBooks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.Queries;
import com.java.vintageBooks.repository.BuyerQueriesRepository;


@Service
public class BuyerQueriesService {
    @Autowired
    private BuyerQueriesRepository buyerQueriesRepository;
    public Queries saveBuyerQuery(Queries buyerQuery){
        return buyerQueriesRepository.save(buyerQuery);
    }
}
