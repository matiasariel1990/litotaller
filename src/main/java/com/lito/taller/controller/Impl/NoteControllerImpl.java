package com.lito.taller.controller.Impl;


import com.lito.taller.controller.NoteController;
import com.lito.taller.dto.Note.NoteContentDTO;
import com.lito.taller.dto.Note.NoteDTO;
import com.lito.taller.service.NoteService;
import com.lito.taller.service.noteSupport.impl.ClientNote;
import com.lito.taller.service.noteSupport.impl.VehicleNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class NoteControllerImpl implements NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    ClientNote clientNote;

    @Autowired
    VehicleNote vehicleNote;

    @Override
    public Set<NoteDTO> getAllNote() {
        return null;
    }

    @Override
    public NoteDTO createWorkNote(@RequestBody String content,
                                  @PathVariable long id) {

        //return this.workService.createNote(content, this.workNote, id)
        return null;
    }

    @Override
    public NoteDTO createVehiclesNote(@RequestBody String content,
                                      @PathVariable long id) {

        return this.noteService.createNote(content, this.vehicleNote, id);

    }

    @Override
    public NoteDTO createClientNote(@RequestBody String content,
                                     @PathVariable long id) {
        //NoteType noteType = new ClientNote();

        return this.noteService.createNote(content, this.clientNote, id);
    }

    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        return null;
    }

    @Override
    public void deleteNote(long id) {

    }

    @Override
    public Set<NoteContentDTO> getClientNotes(long id){ return noteService.getClientNotes(id); }
}
