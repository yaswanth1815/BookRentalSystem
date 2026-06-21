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
@Table(name="sellerbooks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowAllBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sellername;
    private String bookname;
    private String author;
    private String pages;
    private String price;
    private String mobile;
    private String mailid;
    private String saletype;
    private String quantity;
}
