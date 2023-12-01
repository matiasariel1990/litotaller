package com.lito.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false, length = 10)
    String car_id;

    @Column(nullable = false, length = 30)
    String brand;

    @Column(nullable = false, length = 30)
    String model;

    @Column(nullable = false)
    int year;

    @Column(nullable = false, length = 200)
    String summary;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    Client client;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    List<Note> notes = new ArrayList<>();

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    List<Work> works = new ArrayList<>();


}
