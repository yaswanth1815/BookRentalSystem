package com.java.vintageBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.vintageBooks.entity.Queries;

public interface SellerQueriesRepository extends JpaRepository<Queries,Integer>{
    Queries save(Queries query);
}
