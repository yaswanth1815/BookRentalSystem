package com.java.vintageBooks.repository;

import com.java.vintageBooks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);
    User findByUsernameAndPassword(String username,String password);
    boolean existsByUsername(String username);
}