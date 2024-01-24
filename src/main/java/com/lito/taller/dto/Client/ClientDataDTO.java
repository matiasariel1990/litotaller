    package com.lito.taller.dto.Client;

import com.lito.taller.entity.Client;
import com.lito.taller.entity.Note;
import com.lito.taller.entity.Vehicle;
import com.lito.taller.entity.Work;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDataDTO {
    long id;
    String name;
    String tel;
    String summary;
    List<Note> notes;
    List<Vehicle> vehicles;
    List<Work> works;

    public ClientDataDTO(Client client){
        this.id =  client.getId();
        this.name = client.getName();
        this.tel = client.getTel();
        this.summary = client.getSummary();
        //this.notes = client.getNotes();
        //this.vehicles = client.getVehicles();
        //this.works = client.getWorks();
    }
}
