package com.lito.taller.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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

    @JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    List<Note> notes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    List<Vehicle> vehicles;

    @JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    List<Work> works= new ArrayList<>();

    public Client(long id, String name, String summary, String tel){
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.tel = tel;
    }
}
