package com.lito.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

/**
 * / Tabla de notas, se pueden relacionar tanto a una entidad vehículo, como cliente y trabajo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;


    //revisar estrategias para las fechas
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    Date date;

    @Column(nullable = false, length = 500)
    String content;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name="client_id", nullable = true,
            updatable = false, foreignKey = @ForeignKey(name = "FK_NOTE_CLIENT_ID"))
    Client client;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name="vehicle_id", nullable = true,
                updatable = false, foreignKey = @ForeignKey(name = "FK_NOTE_VEHICLE_ID"))
    Vehicle vehicle;


    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name="work_id", nullable = true,
                updatable = false, foreignKey = @ForeignKey(name = "FK_NOTE_WORK_ID"))
    Work work;
}
