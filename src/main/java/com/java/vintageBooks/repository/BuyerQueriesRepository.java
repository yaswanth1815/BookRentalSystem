package com.java.vintageBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.Queries;

@Service
public interface BuyerQueriesRepository extends JpaRepository<Queries,Integer>{
    Queries save(Queries buyerquery);
}
