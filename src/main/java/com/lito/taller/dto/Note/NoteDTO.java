package com.lito.taller.dto.Note;

import com.lito.taller.entity.Client;
import com.lito.taller.entity.Note;
import com.lito.taller.entity.Vehicle;
import com.lito.taller.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {
    long id;
    Date date;
    String content;
    Client client;
    Vehicle vehicle;
    Work work;

    public NoteDTO(Note note){
        this.id = note.getId();
        this.date = note.getDate();
        this.content = note.getContent();
        this.client = note.getClient();
        this.vehicle = note.getVehicle();
        this.work = note.getWork();

    }

    public Note mapToEntity(){
        Note note = new Note();
        note.setId(this.id);
        note.setDate(this.date);
        note.setContent(this.content);
        note.setClient(this.client);
        note.setVehicle(this.vehicle);
        note.setWork(this.work);
        return note;
    }
}
