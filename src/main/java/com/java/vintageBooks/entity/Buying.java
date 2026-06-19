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
@Table(name="buying")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String bookName;
    private String author;
    private String pages;
    private String price;
    private String seller;
    private String mobile;
    private String mailid;
}
