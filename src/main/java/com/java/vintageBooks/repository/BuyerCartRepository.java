package com.java.vintageBooks.repository;

import com.java.vintageBooks.entity.BuyerCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyerCartRepository extends JpaRepository<BuyerCart, Integer> {

    List<BuyerCart> findByBuyerusername(String buyerusername);
    BuyerCart findByBuyerusernameAndSellerbooks_Id(String buyerusername,Integer sellerbookid);

}
