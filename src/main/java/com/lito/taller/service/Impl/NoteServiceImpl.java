package com.lito.taller.service.Impl;

import com.lito.taller.dto.Note.NoteContentDTO;
import com.lito.taller.dto.Note.NoteDTO;
import com.lito.taller.entity.Note;
import com.lito.taller.repository.NoteRepository;
import com.lito.taller.service.NoteService;
import com.lito.taller.service.noteSupport.NoteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;



    public NoteServiceImpl(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    @Override
    public Set<NoteDTO> getAllNotes() {
        return null;
    }


    @Override
    public NoteDTO createNote(String content, NoteType noteType, long id) {

        Note note = noteType.createNote(id);
        note.setContent(content);
        note.setDate(new Date());

        return new NoteDTO (
                this.noteRepository.save(note)
        );
    }


    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        return null;
    }

    @Override
    public void deleteNote(Long id) {
    }

    @Override
    public Set<NoteContentDTO> getClientNotes(long id){
        return noteRepository.findByClientId(id);
    }

}
