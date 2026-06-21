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
@Table(name="")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Queries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer queryid;
    private String username;
    private String email;
    private String message;
    private String usertype;

}
