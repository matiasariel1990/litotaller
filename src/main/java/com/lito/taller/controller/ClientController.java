package com.lito.taller.controller;


import com.lito.taller.entity.Client;
import com.lito.taller.dto.ClientDTO;
import com.lito.taller.entity.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("Client")
public interface ClientController {

    public Set<ClientDTO> getAllClient();

    public ClientDTO createClient(@RequestBody ClientDTO clientDTO);

    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO);

    public ResponseEntity<String> deleteClient(@RequestBody ClientDTO clientDTO);


}
