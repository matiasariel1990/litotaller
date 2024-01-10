package com.lito.taller.controller;


import com.lito.taller.dto.NoteDTO;
import org.springframework.http.ResponseEntity;
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
    public NoteDTO updateNote(@RequestBody NoteDTO noteDTO);

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable long id);

}
