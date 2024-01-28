package com.lito.taller.service;

import com.lito.taller.dto.Note.NoteContentDTO;
import com.lito.taller.dto.Note.NoteDTO;
import com.lito.taller.service.noteSupport.NoteType;

import java.util.Set;

public interface NoteService {
    public Set<NoteDTO> getAllNotes();

    public NoteDTO createNote(String content, NoteType noteType, long id);

    public NoteDTO updateNote(long id, String content);

    public void deleteNote(Long id);

    public Set<NoteContentDTO> getClientNotes(long id);

    public Set<NoteContentDTO> getVehicleNotes(long id);

    public Set<NoteContentDTO> getWorkNotes(long id);


}
