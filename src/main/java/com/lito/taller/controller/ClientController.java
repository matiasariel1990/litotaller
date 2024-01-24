package com.lito.taller.controller;


import com.lito.taller.dto.Client.ClientDataDTO;
import com.lito.taller.dto.Client.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RequestMapping("Client")
public interface ClientController {

    @GetMapping()
    public Set<ClientDTO> getAllClient();

    @GetMapping("/{id}")
    public ClientDTO getById(@PathVariable long Id);

    @GetMapping("/{id}/data")
    public ClientDataDTO getDataById(@PathVariable long id);

    @PostMapping()
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO);

    @PutMapping()
    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable long id);

}
