package com.lito.taller.controller.Impl;


import com.lito.taller.controller.NoteController;
import com.lito.taller.dto.NoteDTO;
import com.lito.taller.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class NoteControllerImpl implements NoteController {

    @Autowired
    NoteService noteService;

    @Override
    public Set<NoteDTO> getAllNote() {
        return null;
    }

    @Override
    public ResponseEntity createNote(NoteDTO noteDTO) {

        if(noteDTO.getClient()==null
            && noteDTO.getWork()==null
            && noteDTO.getVehicle()==null
            )
        {
            return new ResponseEntity<>("", HttpStatusCode.valueOf(400));
        }

        return new ResponseEntity(
                noteService.createNote(noteDTO),
                HttpStatusCode.valueOf(200)
        );
    }

    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        return null;
    }

    @Override
    public void deleteNote(long id) {

    }
}
