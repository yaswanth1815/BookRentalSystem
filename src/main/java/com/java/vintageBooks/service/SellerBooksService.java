package com.java.vintageBooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.vintageBooks.entity.Seller;
import com.java.vintageBooks.entity.SellerBooks;
import com.java.vintageBooks.repository.SellerBooksRepository;

@Service
public class SellerBooksService {
    @Autowired
    private SellerBooksRepository sellerBookRepository;
    
    public SellerBooks saveBook(SellerBooks currentSellerBooks,Seller seller){
        
        SellerBooks databaseSellerBook=presenceOfBook(
                                         currentSellerBooks.getName(),
                                         currentSellerBooks.getAuthor(),
                                         currentSellerBooks.getType()
                                         );
        if(databaseSellerBook==null){
            currentSellerBooks.setUsername(seller.getUsername());
            currentSellerBooks.setMailid(seller.getMailid());
            currentSellerBooks.setMobile(seller.getMobile());
            return sellerBookRepository.save(currentSellerBooks);
        }
        
        String qty1=databaseSellerBook.getQuantity();
        String qtyrem1=databaseSellerBook.getQuantity_remaining();
        String qty2=currentSellerBooks.getQuantity();
        String qtyrem2=currentSellerBooks.getQuantity_remaining();

        Integer qtty=Integer.parseInt(qty1)+Integer.parseInt(qty2);
        Integer qttyrem=Integer.parseInt(qtyrem1)+Integer.parseInt(qtyrem2);

        String final_qty=String.valueOf(qtty);
        String final_qtyrem=String.valueOf(qttyrem);
        databaseSellerBook.setQuantity(final_qty);
        databaseSellerBook.setQuantity_remaining(final_qtyrem);
        return sellerBookRepository.save(databaseSellerBook);
    }
    
    public SellerBooks presenceOfBook(String name,String author,String type){
        return sellerBookRepository.findByNameAndAuthorAndType(name, author, type);
    }
    public List<SellerBooks> getAllBooks(){
        return sellerBookRepository.findAll();
    }

    public void deleteBook(Integer id){
        sellerBookRepository.deleteById(id);
    }

    public List<SellerBooks> getBookByName(String name){
        return sellerBookRepository.findByNameContaining(name);
    }

    public List<SellerBooks> getBookByAuthor(String author){
        return sellerBookRepository.findByAuthorContaining(author);
    }

    public List<SellerBooks> getBookByType(String type){
        return sellerBookRepository.findByType(type);
    }
}
