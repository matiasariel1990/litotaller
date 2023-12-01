package com.lito.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false, length = 500)
    String summary;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date date_reception;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    Date date_start;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    Date date_finish;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date date_pickup;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    Vehicle vehicle;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    Client client;

    @OneToMany(mappedBy = "work", fetch = FetchType.LAZY)
    List<Note> notes = new ArrayList<>();



}
