package com.java.vintageBooks.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="admins")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admins {
    @Id
    private String adminname;
    private String adminpassword;
}
