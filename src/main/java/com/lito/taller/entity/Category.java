package com.lito.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * / categorias para los work_details de los trabajos (ej, mano de obra, repuesto, trabajo externo)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false, length = 50)
    String label;

    @Column(nullable = false, length = 10)
    String colour;
}
