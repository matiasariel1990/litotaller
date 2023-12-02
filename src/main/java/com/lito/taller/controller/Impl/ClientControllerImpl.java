package com.lito.taller.controller.Impl;

import com.lito.taller.controller.ClientController;
import com.lito.taller.dto.ClientDTO;
import com.lito.taller.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("Client")
public class ClientControllerImpl implements ClientController {

    @Autowired
    ClientService clientService;

    @Override
    @GetMapping()
    public Set<ClientDTO> getAllClient() {
        return clientService.getAllClients();
    }

    @Override
    @GetMapping("/{id}")
    public ClientDTO getById(long id){
        return clientService.gteById(id);
    }

    @Override
    @PostMapping()
    public ClientDTO createClient(ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }
    @Override
    @PutMapping()
    public ClientDTO updateClient(ClientDTO clientDTO) {
        return clientService.updateClient(clientDTO);
    }

    @Override
    @DeleteMapping("")
    public ResponseEntity<String> deleteClient(ClientDTO clientDTO) {
        return new ResponseEntity<>(clientDTO.getName() + "Eliminado", HttpStatusCode.valueOf(200));
    }
}
