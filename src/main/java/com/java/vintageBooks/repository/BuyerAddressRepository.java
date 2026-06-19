package com.java.vintageBooks.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.java.vintageBooks.entity.BuyerAddress;

public interface BuyerAddressRepository extends JpaRepository<BuyerAddress,Integer> {
    List<BuyerAddress>  findByUsername(String username);
    List<BuyerAddress> findByStatus(String status);
    List<BuyerAddress> findBySeller(String seller);
}
