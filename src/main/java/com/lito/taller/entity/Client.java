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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false, length = 100)
    String name;

    @Column(nullable = true, length = 20)
    String tel;

    @Column(nullable = true, length = 255)
    String summary;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    List<Note> notes = new ArrayList<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    List<Work> works = new ArrayList<>();
}
