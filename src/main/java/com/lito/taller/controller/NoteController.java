package com.lito.taller.controller;

import com.lito.taller.dto.Note.NoteContentDTO;
import com.lito.taller.dto.Note.NoteDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("Note")
public interface NoteController {
    @GetMapping()
    public Set<NoteDTO> getAllNote();

    @PostMapping("/client/{id}")
    public NoteDTO createClientNote(@RequestBody String content,
                                     @PathVariable long id);

    @PostMapping("/work/{id}")
    public NoteDTO createWorkNote(@RequestBody String content,
                                    @PathVariable long id);

    @PostMapping("/vehicle/{id}")
    public NoteDTO createVehiclesNote(@RequestBody String content,
                              @PathVariable long id);

    @PutMapping()
    public NoteDTO updateNote(@RequestBody NoteContentDTO noteContentDTO);

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable long id);

    @GetMapping("/client/{id}")
    public Set<NoteContentDTO> getClientNotes(@PathVariable long id);

    @GetMapping("/vehicle/{id}")
    public Set<NoteContentDTO> getVehicleNotes(@PathVariable long id);

    @GetMapping("/work/{id}")
    public Set<NoteContentDTO> getWorkNotes(@PathVariable long id);

}
