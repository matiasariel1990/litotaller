package com.lito.taller.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    String car_number;

    @Column(nullable = true, length = 30)
    String brand;

    @Column(nullable = true, length = 30)
    String model;

    @Column(nullable = true)
    int year;

    @Column(nullable = true, length = 200)
    String summary;

@JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", nullable = false,
                updatable = true, foreignKey = @ForeignKey(name = "FK_VEHICLE_CLIENT_ID"))
    Client client;


    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    List<Note> notes = new ArrayList<>();


    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    List<Work> works = new ArrayList<>();

}
