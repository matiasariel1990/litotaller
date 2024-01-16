package com.lito.taller.controller.Impl;


import com.lito.taller.controller.NoteController;
import com.lito.taller.dto.NoteDTO;
import com.lito.taller.service.NoteService;
import com.lito.taller.service.noteSupport.NoteType;
import com.lito.taller.service.noteSupport.impl.ClientNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class NoteControllerImpl implements NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    ClientNote clientNote;

    @Override
    public Set<NoteDTO> getAllNote() {
        return null;
    }

    @Override
    public NoteDTO createWorkNote(@RequestBody String content,
                                  @PathVariable long id) {

        //return workService.createNote(content, workNote, id)
        return null;
    }

    @Override
    public NoteDTO createVehiclesNote(@RequestBody String content,
                                      @PathVariable long id) {

        //return vehicleService.createNote(content, vehicleNote, id);
        return null;
    }

    @Override
    public NoteDTO createClientNote(@RequestBody String content,
                                     @PathVariable long id) {
        //NoteType noteType = new ClientNote();

        return noteService.createNote(content, clientNote, id);
    }

    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        return null;
    }

    @Override
    public void deleteNote(long id) {

    }
}
