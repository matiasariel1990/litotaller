package com.lito.taller.service.Impl;

import com.lito.taller.dto.NoteDTO;
import com.lito.taller.entity.Client;
import com.lito.taller.entity.Note;
import com.lito.taller.repository.NoteRepository;
import com.lito.taller.service.NoteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    public NoteDTO createNote(NoteDTO noteDTO) {

        return new NoteDTO(
                noteRepository.save(noteDTO.mapToEntity())

                );
    }

    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        return null;
    }

    @Override
    public void deleteNote(Long id) {

    }

    private NoteDTO mapToDto(Note note){
        return new NoteDTO(
                note.getId(),       note.getDate(),
                note.getContent(),  note.getClient(),
                note.getVehicle(),  note.getWork()
        );
    }

}
