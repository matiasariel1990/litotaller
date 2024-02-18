package com.lito.taller.entity;

import com.lito.taller.entity.enums.WorkStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    //@Column(nullable = false, length = 20)
    @Enumerated(EnumType.ORDINAL)
    WorkStatusEnum status;


    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date dateReception;


    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date datePickup;


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="vehicle_id", nullable = false,
                updatable = false, foreignKey = @ForeignKey(name = "FK_WORK_VEHICLE_ID"))
    Vehicle vehicle;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", nullable = false,
                updatable = false, foreignKey = @ForeignKey(name = "FK_WORK_CLIENT_ID"))
    Client client;

    //@OneToMany(mappedBy = "work", fetch = FetchType.LAZY)
    //List<Note> notes = new ArrayList<>();

    //@OneToMany(mappedBy = "work", fetch = FetchType.LAZY)
    //List<Work_Detail> work_details = new ArrayList<>();

}
