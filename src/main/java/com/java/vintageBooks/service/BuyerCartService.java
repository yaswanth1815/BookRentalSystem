package com.java.vintageBooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.BuyerCart;
import com.java.vintageBooks.entity.SellerBooks;
import com.java.vintageBooks.repository.BuyerCartRepository;

@Service
public class BuyerCartService {

    @Autowired
    private BuyerCartRepository buyerCartRepository;

    public BuyerCart addToCart(String buyerusername,SellerBooks sellerBooks) {
        BuyerCart existingCart=buyerCartRepository.findByBuyerusernameAndSellerbooks_Id(buyerusername, sellerBooks.getId());
        if(existingCart!=null){

            if(existingCart.getQuantity()>=Integer.parseInt(sellerBooks.getQuantityremaining())){
                throw new RuntimeException("Stock Unaivalable");
            }
            existingCart.setQuantity(existingCart.getQuantity()+1);
            return buyerCartRepository.save(existingCart);
        }

        BuyerCart buyerCart=new BuyerCart();
        buyerCart.setBuyerusername(buyerusername);
        buyerCart.setQuantity(1);
        buyerCart.setSellerbooks(sellerBooks);
        return buyerCartRepository.save(buyerCart);
    }

    public List<BuyerCart> getCartByUsername(String buyerusername) {
        return buyerCartRepository.findByBuyerusername(buyerusername);
    }

    public List<BuyerCart> getAllCartItems() {
        return buyerCartRepository.findAll();
    }

    public BuyerCart getCartItemById(Integer id) {
        return buyerCartRepository.findById(id).orElse(null);
    }

    public void deleteCartItem(Integer id) {
        buyerCartRepository.deleteById(id);
    }
}