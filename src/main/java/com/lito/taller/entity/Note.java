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
    @Temporal(TemporalType.DATE) //limita a solo fecha
    Date date;  //quiza usar Calendar?

    @Column(nullable = false, length = 500)
    String content;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    Vehicle vehicle;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    Client client;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    Work work;
}
