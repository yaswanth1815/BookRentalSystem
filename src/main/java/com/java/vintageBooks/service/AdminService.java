package com.java.vintageBooks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.Admins;
import com.java.vintageBooks.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admins checkAdmin(String adname,String adpassword){
        return adminRepository.findByAdminnameAndAdminpassword(adname, adpassword);
    }
}
