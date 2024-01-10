package com.lito.taller.service;

import com.lito.taller.dto.CategoryDTO;
import com.lito.taller.dto.NoteDTO;
import com.lito.taller.entity.Client;
import com.lito.taller.entity.Note;
import com.lito.taller.service.noteSupport.NoteType;

import java.util.Set;

public interface NoteService {
    public Set<NoteDTO> getAllNotes();

    public NoteDTO createNote(String content, NoteType noteType, long id);

    public NoteDTO updateNote(NoteDTO noteDTO);

    public void deleteNote(Long id);


}
