package com.lito.taller.controller.Impl;


import com.lito.taller.controller.NoteController;
import com.lito.taller.dto.NoteDTO;
import com.lito.taller.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class NoteControllerImpl implements NoteController {

    @Autowired
    NoteService NoteService;

    @Override
    public Set<NoteDTO> getAllNote() {
        return null;
    }

    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {
        return null;
    }

    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        return null;
    }

    @Override
    public void deleteNote(long id) {

    }
}
