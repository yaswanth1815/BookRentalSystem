package com.java.vintageBooks.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.BuyerAddress;
import com.java.vintageBooks.repository.BuyerAddressRepository;

@Service
public class BuyerAddressService {
    
    @Autowired
    private BuyerAddressRepository buyerAddressRepository;

    public BuyerAddress saveAddress(BuyerAddress buyerAddress) {
        return buyerAddressRepository.save(buyerAddress);
    }

    public List<BuyerAddress> getAllOrders() {
        return buyerAddressRepository.findAll();
    }

    public List<BuyerAddress> getOrdersByUsername(String username) {
        return buyerAddressRepository.findByUsername(username);
    }

    public List<BuyerAddress> getOrdersBySeller(String seller) {
        return buyerAddressRepository.findBySeller(seller);
    }

    public List<BuyerAddress> getOrdersByStatus(String status) {
        return buyerAddressRepository.findByStatus(status);
    }

    public BuyerAddress getOrderById(Integer id) {
        return buyerAddressRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Integer id) {
        buyerAddressRepository.deleteById(id);
    }
}
