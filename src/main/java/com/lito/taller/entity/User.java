package com.lito.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false, length = 30, unique = true)
    String userName;

    @Column(nullable = false, length = 30)
    String password;

    @Column(nullable = true, length = 100)
    String email;

}
