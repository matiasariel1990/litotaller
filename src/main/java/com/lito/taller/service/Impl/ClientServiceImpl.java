package com.lito.taller.service.Impl;


import com.lito.taller.dto.ClientDTO;
import com.lito.taller.entity.Category;
import com.lito.taller.entity.Client;
import com.lito.taller.exeption.ResourseNotFoundExeption;
import com.lito.taller.repository.ClientRepository;
import com.lito.taller.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Set<ClientDTO> getAllClients() {
        Set<ClientDTO> allClients = new HashSet<>();
        allClients.addAll(clientRepository.findAll().
                stream().map(client ->
                { return mapToDTO(client); }).collect(Collectors.toSet())
        );
        return allClients;
    }

    @Override
    public ClientDTO gteById(Long id) {
        return mapToDTO(clientRepository.findById(id).
                orElseThrow(()-> new ResourseNotFoundExeption(Category.class.getName()))
        );
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        return mapToDTO(
                clientRepository.save(mapToEntity(clientDTO))
        );
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = clientRepository.findById(
                clientDTO.getId()
        ).
        orElseThrow( () -> new ResourseNotFoundExeption(Client.class.getName()));
        client.setName(clientDTO.getName());
        client.setTel(clientDTO.getTel());
        client.setSummary(clientDTO.getSummary());
        return mapToDTO( clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(
                (clientRepository.findById(id).
                orElseThrow(() -> new ResourseNotFoundExeption(Category.class.getName()))
                .getId())
        );
    }

    private ClientDTO mapToDTO(Client client){
        return new ClientDTO (client.getId(), client.getName(),
                client.getTel(), client.getSummary(),
                client.getNotes(), client.getVehicles(),
                client.getWorks()
        );
    }

    private Client mapToEntity(ClientDTO clientDTO){
        return new Client (clientDTO.getId(), clientDTO.getName(),
                clientDTO.getTel(), clientDTO.getSummary(),
                null, null, null
        );
    }
}
