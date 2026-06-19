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
@Table(name = "buyeraddress")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String name;
    private String author;
    private String seller;
    private String address;
    private String village;
    private String pin;
    private String state;
    private String sc1;
    private String sc2;
    private Double ppu;
    private Double price;
    private String status;
    private String bname;
    private String bcon1;
    private String bcon2;
    private Integer requiredQuantity;
    private String required;
    private String ordered;
    private String delivered;
    private String returned;
    private Integer days;
}
