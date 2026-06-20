package com.java.vintageBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.vintageBooks.entity.Queries;

public interface QueryRepository extends JpaRepository<Queries,Integer>{
    
}
