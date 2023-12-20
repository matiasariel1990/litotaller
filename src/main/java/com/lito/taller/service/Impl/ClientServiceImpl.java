package com.lito.taller.service.Impl;


import com.lito.taller.dto.Client.ClientDataDTO;
import com.lito.taller.dto.Client.ClientDTO;
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
        allClients.addAll(
            clientRepository
                .findAll()
                .stream()
                .map(client -> { return new ClientDTO(client); })
                .collect(Collectors.toSet())
        );
        return allClients;
    }

    @Override
    public ClientDTO gteById(Long id) {
        return new ClientDTO(
            clientRepository
                .findById(id)
                .orElseThrow( ()-> new ResourseNotFoundExeption(Category.class.getName()) )
            );
    }

    @Override
    public ClientDataDTO getDataById(long id){
        Client client = clientRepository
            .findById(id)
            .orElseThrow( ()-> new ResourseNotFoundExeption(Category.class.getName()) );

        return new ClientDataDTO(client);
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        return new ClientDTO(
                clientRepository.save(clientDTO.mapToEntity())
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
        return new ClientDTO( clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(
                (clientRepository.findById(id).
                orElseThrow(() -> new ResourseNotFoundExeption(Category.class.getName()))
                .getId())
        );
    }



}
