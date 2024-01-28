package com.lito.taller.controller.Impl;

import com.lito.taller.controller.ClientController;
import com.lito.taller.dto.client.ClientDataDTO;
import com.lito.taller.dto.client.ClientDTO;
import com.lito.taller.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ClientControllerImpl implements ClientController {

    @Autowired
    ClientService clientService;

    @Override
    public Set<ClientDTO> getAllClient() {
        return this.clientService.getAllClients();
    }

    @Override
    public ClientDTO getById(long id){
        return this.clientService.getById(id);
    }
    @Override
    public ClientDataDTO getDataById(@PathVariable long id){
        return this.clientService.getDataById(id);
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        return this.clientService.createClient(clientDTO);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        return this.clientService.updateClient(clientDTO);
    }

    @Override
    public ResponseEntity<String> deleteClient(@PathVariable long id) {
        this.clientService.deleteClient(id);
        return new ResponseEntity<>("OK", HttpStatusCode.valueOf(200));
    }
}
