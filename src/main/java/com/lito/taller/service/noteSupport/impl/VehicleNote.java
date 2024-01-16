package com.lito.taller.service.noteSupport.impl;

import com.lito.taller.entity.Note;
import com.lito.taller.service.noteSupport.NoteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleNote implements NoteType {

    //@Autowired
    //VehicleService vehicleService;

    @Override
    public Note createNote(long id) {
        //VehicleDTO vehicleDTO = vehicleService.getById(id);

        Note note = new Note();
        //note.setVehicle(vehicleDTO.mapToEntity());

        return note;
    }
}
