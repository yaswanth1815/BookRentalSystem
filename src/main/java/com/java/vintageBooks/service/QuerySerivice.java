package com.java.vintageBooks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.repository.QueryRepository;
import jakarta.persistence.Query;

@Service
public class QuerySerivice {

    @Autowired
    private QueryRepository queryRepository;

    public Query getQueryDetails(){
        queryRepository.get
    }
}
