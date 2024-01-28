package com.lito.taller.service.Impl;

import com.lito.taller.dto.Note.NoteContentDTO;
import com.lito.taller.dto.Note.NoteDTO;
import com.lito.taller.entity.Note;
import com.lito.taller.exeption.ResourseNotFoundExeption;
import com.lito.taller.repository.NoteRepository;
import com.lito.taller.service.NoteService;
import com.lito.taller.service.noteSupport.NoteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Set<NoteDTO> getAllNotes() {
        Set<NoteDTO> allNotes = new HashSet<>();
        allNotes.addAll(
                this.noteRepository
                        .findAll()
                        .stream()
                        .map(note -> { return new NoteDTO(note); })
                        .collect(Collectors.toSet())
        );
        return allNotes;
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
    public NoteDTO updateNote(long id, String content) {

        Note note = this.noteRepository.findById(id)
        .orElseThrow( () -> new ResourseNotFoundExeption(Note.class.getName()) );

        note.setContent(content);
        return new NoteDTO( this.noteRepository.save(note) );
    }

    @Override
    public void deleteNote(Long id) {
        this.noteRepository.deleteById(
                (this.noteRepository.findById(id)
                        .orElseThrow(
                                () -> new ResourseNotFoundExeption( Note.class.getName() )
                        )
                        .getId())
        );
    }

    @Override
    public Set<NoteContentDTO> getClientNotes(long id){
        Set<NoteContentDTO> allClientNotes = new HashSet<>();
        allClientNotes.addAll(
            this.noteRepository
                .findByClientId(id)
                    .stream()
                    .collect(Collectors.toSet())
        );
        return allClientNotes;

        //return this.noteRepository.findByClientId(id);
    }

    @Override
    public Set<NoteContentDTO> getVehicleNotes(long id) {
        Set<NoteContentDTO> allVehicleNotes = new HashSet<>();
        allVehicleNotes.addAll(
                this.noteRepository
                        .findByVehicleId(id)
                        .stream()
                        .collect(Collectors.toSet())
        );
        return allVehicleNotes;
    }

    @Override
    public Set<NoteContentDTO> getWorkNotes(long id) {
        Set<NoteContentDTO> allWorkNotes = new HashSet<>();
        allWorkNotes.addAll(
                this.noteRepository
                        .findByWorkId(id)
                        .stream()
                        .collect(Collectors.toSet())
        );
        return allWorkNotes;
    }

}
