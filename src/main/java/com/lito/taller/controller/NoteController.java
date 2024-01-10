package com.lito.taller.controller;


import com.lito.taller.dto.NoteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RequestMapping("Note")
public interface NoteController {
    @GetMapping()
    public Set<NoteDTO> getAllNote();

    @PostMapping()
    public ResponseEntity createNote(@RequestBody NoteDTO noteDTO);

    @PutMapping()
    public NoteDTO updateNote(@RequestBody NoteDTO noteDTO);

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable long id);

}
