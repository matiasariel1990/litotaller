package com.lito.taller.service.Impl;


import com.lito.taller.dto.Client.ClientDataDTO;
import com.lito.taller.dto.Client.ClientDTO;
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
        allClients.addAll(
            this.clientRepository
                .findAll()
                .stream()
                .map(client -> { return new ClientDTO(client); })
                .collect(Collectors.toSet())
        );
        return allClients;
    }

    @Override
    public ClientDTO getById(Long id) {
        return new ClientDTO(
            this.clientRepository
                .findById(id)
                .orElseThrow( ()-> new ResourseNotFoundExeption(Client.class.getName()) )
            );
    }

    @Override
    public ClientDataDTO getDataById(long id){
        Client client = this.clientRepository
            .findById(id)
            .orElseThrow( ()-> new ResourseNotFoundExeption(Client.class.getName()) );

        return new ClientDataDTO(client);
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        return new ClientDTO(
                this.clientRepository.save(clientDTO.mapToEntity())
        );
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = this.clientRepository.findById(
                clientDTO.getId()
        ).
        orElseThrow( () -> new ResourseNotFoundExeption(Client.class.getName()));
        client.setName(clientDTO.getName());
        client.setTel(clientDTO.getTel());
        client.setSummary(clientDTO.getSummary());
        return new ClientDTO( this.clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        this.clientRepository.deleteById(
                (this.clientRepository.findById(id)
                        .orElseThrow(
                                () -> new ResourseNotFoundExeption (Client.class.getName() )
                        )
                        .getId())
        );
    }



}
