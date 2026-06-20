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
                                         currentSellerBooks.getBookname(),
                                         currentSellerBooks.getAuthor(),
                                         currentSellerBooks.getSaletype()
                                         );
        if(databaseSellerBook==null){
            currentSellerBooks.setSellername(seller.getName());
            currentSellerBooks.setMailid(seller.getMailid());
            currentSellerBooks.setMobile(seller.getMobile());
            currentSellerBooks.setQuantityremaining(currentSellerBooks.getQuantity());
            currentSellerBooks.setSellerusername(seller.getUsername());
            return sellerBookRepository.save(currentSellerBooks);
        }
        
        String qty1=databaseSellerBook.getQuantity();
        String qtyrem1=databaseSellerBook.getQuantityremaining();
        String qty2=currentSellerBooks.getQuantity();

        Integer qtty=Integer.parseInt(qty1)+Integer.parseInt(qty2);
        Integer qttyrem=Integer.parseInt(qtyrem1)+Integer.parseInt(qty2);

        String final_qty=String.valueOf(qtty);
        String final_qtyrem=String.valueOf(qttyrem);
        databaseSellerBook.setQuantity(final_qty);
        databaseSellerBook.setQuantityremaining(final_qtyrem);
        return sellerBookRepository.save(databaseSellerBook);
    }
    
    public List<SellerBooks> getSellerBooksbySellerusername(String sellerusername){
        return sellerBookRepository.findBySellerusername(sellerusername);
    }

    public SellerBooks presenceOfBook(String bookname,String author,String saletype){
        return sellerBookRepository.findByBooknameAndAuthorAndSaletype(bookname, author, saletype);
    }
    public List<SellerBooks> getAllBooks(){
        return sellerBookRepository.findAll();
    }

    public void deleteBook(Integer id){
        sellerBookRepository.deleteById(id);
    }

    public List<SellerBooks> getBookByName(String bookname){
        return sellerBookRepository.findByBooknameContaining(bookname);
    }

    public List<SellerBooks> getBookByAuthor(String author){
        return sellerBookRepository.findByAuthorContaining(author);
    }

    public List<SellerBooks> getBookByType(String saletype){
        return sellerBookRepository.findBySaletype(saletype);
    }
}
