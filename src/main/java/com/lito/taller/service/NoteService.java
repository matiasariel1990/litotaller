package com.lito.taller.service;

import com.lito.taller.dto.CategoryDTO;
import com.lito.taller.dto.NoteDTO;
import com.lito.taller.entity.Client;
import com.lito.taller.entity.Note;

import java.util.Set;

public interface NoteService {
    public Set<NoteDTO> getAllNotes();

    public NoteDTO createNote(NoteDTO noteDTO);

    public NoteDTO updateNote(NoteDTO noteDTO);

    public void deleteNote(Long id);


}
