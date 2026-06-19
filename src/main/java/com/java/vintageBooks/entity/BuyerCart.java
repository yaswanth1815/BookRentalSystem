package com.java.vintageBooks.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String username;
    private String name;
    private String author;
    private Integer pages;
    private Double price;
    private String seller;
    private String sellerContact1;
    private String sellerContact2;
    private String type;
}
