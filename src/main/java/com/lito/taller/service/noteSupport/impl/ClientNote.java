package com.lito.taller.service.noteSupport.impl;

import com.lito.taller.dto.Client.ClientDTO;
import com.lito.taller.entity.Note;
import com.lito.taller.service.ClientService;
import com.lito.taller.service.noteSupport.NoteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClientNote implements NoteType {

    @Autowired
    ClientService clientService;

    @Override
    public Note createNote(long id) {
        ClientDTO clientDTO = clientService.getById( id );

        Note note  = new Note();
        note.setClient(clientDTO.mapToEntity());

        return note;
    }
}
