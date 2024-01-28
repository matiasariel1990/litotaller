package com.lito.taller.controller.Impl;

import com.lito.taller.controller.NoteController;
import com.lito.taller.dto.Note.NoteContentDTO;
import com.lito.taller.dto.Note.NoteDTO;
import com.lito.taller.service.NoteService;
import com.lito.taller.service.noteSupport.impl.ClientNote;
import com.lito.taller.service.noteSupport.impl.VehicleNote;
import com.lito.taller.service.noteSupport.impl.WorkNote;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    VehicleNote vehicleNote;

    @Autowired
    WorkNote workNote;

    @Override
    public Set<NoteDTO> getAllNote() {
        return this.noteService.getAllNotes();
    }

    @Override
    public NoteDTO createWorkNote(@RequestBody String content,
                                  @PathVariable long id) {
        return this.noteService.createNote(content, this.workNote, id);
    }

    @Override
    public NoteDTO createVehiclesNote(@RequestBody String content,
                                      @PathVariable long id) {
        return this.noteService.createNote(content, this.vehicleNote, id);
    }

    @Override
    public NoteDTO createClientNote(@RequestBody String content,
                                     @PathVariable long id) {
        return this.noteService.createNote(content, this.clientNote, id);
    }

    @Override
    public NoteDTO updateNote(@PathVariable long id, @RequestBody String content) {
        return this.noteService.updateNote(id, content);
    }

    @Override
    public void deleteNote(long id) {
        this.noteService.deleteNote(id);
    }

    @Override
    public Set<NoteContentDTO> getClientNotes(long id){
        return this.noteService.getClientNotes(id);
    }

    @Override
    public Set<NoteContentDTO> getVehicleNotes(long id) {
        return this.noteService.getVehicleNotes(id);
    }

    @Override
    public Set<NoteContentDTO> getWorkNotes(long id) {
        return this.noteService.getWorkNotes(id);
    }
}
