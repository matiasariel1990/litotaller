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

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date date_reception;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    Date date_start;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    Date date_finish;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date date_pickup;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="vehicle_id", nullable = false,
                updatable = false, foreignKey = @ForeignKey(name = "FK_WORK_VEHICLE_ID"))
    Vehicle vehicle;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="client_id", nullable = false,
                updatable = false, foreignKey = @ForeignKey(name = "FK_WORK_CLIENT_ID"))
    Client client;

    @OneToMany(mappedBy = "work", fetch = FetchType.LAZY)
    List<Note> notes = new ArrayList<>();

}
