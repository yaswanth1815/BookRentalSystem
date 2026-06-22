package com.java.vintageBooks.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "buyercart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyerCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String buyerusername;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="sellerbookid", referencedColumnName = "id")
    private SellerBooks sellerbooks;
}
