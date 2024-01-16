package com.lito.taller.service.noteSupport.impl;

import com.lito.taller.entity.Note;
import com.lito.taller.service.noteSupport.NoteType;
import org.springframework.stereotype.Service;

@Service
public class WorkNote implements NoteType {

    //@Autowired
    //WorkService workService;

    @Override
    public Note createNote(long id) {
        //WorkDTO workDTO = workService.getById(id);

        Note note = new Note();
        //note.setWork(workDTO.mapToEntity());

        return note;
    }
}
