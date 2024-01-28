package com.lito.taller.service;

import com.lito.taller.dto.client.ClientDataDTO;
import com.lito.taller.dto.client.ClientDTO;

import java.util.Set;

public interface ClientService {
    public Set<ClientDTO> getAllClients();

    public ClientDTO getById(Long id);

    public ClientDataDTO getDataById(long id);

    public ClientDTO createClient(ClientDTO clientDTO);

    public ClientDTO updateClient(ClientDTO clientDTO);

    public void deleteClient(Long id);

}
