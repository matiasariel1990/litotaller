package com.lito.taller.controller;


import com.lito.taller.dto.Client.ClientDataDTO;
import com.lito.taller.dto.Client.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("Client")
public interface ClientController {

    public Set<ClientDTO> getAllClient();

    public ClientDTO getById(@PathVariable long Id);

    public ClientDataDTO getDataById(@PathVariable long id);

    public ClientDTO createClient(@RequestBody ClientDTO clientDTO);

    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO);

    public ResponseEntity<String> deleteClient(@PathVariable long id);


}
