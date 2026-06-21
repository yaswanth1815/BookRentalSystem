package com.java.vintageBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.vintageBooks.entity.Admins;

public interface AdminRepository extends JpaRepository<Admins,String>{

    Admins findByAdminnameAndAdminpassword(String adname, String adpassword);
    
}
