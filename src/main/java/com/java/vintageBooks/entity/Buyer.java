package com.java.vintageBooks.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "buyer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {

    private String name;
    private String mobile;
    @Id
    private String username;
    private String password;
    private String mailid;
}
