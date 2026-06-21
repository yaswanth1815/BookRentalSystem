package com.java.vintageBooks.repository;

import com.java.vintageBooks.entity.ShowAllBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowAllBooksRepository extends JpaRepository<ShowAllBooks, Integer> {

}