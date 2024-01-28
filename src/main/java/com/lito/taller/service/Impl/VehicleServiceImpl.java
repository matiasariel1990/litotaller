package com.lito.taller.service.Impl;

import com.lito.taller.dto.client.ClientDTO;
import com.lito.taller.dto.VehicleDTO;
import com.lito.taller.entity.Client;
import com.lito.taller.entity.Vehicle;
import com.lito.taller.exeption.ResourseNotFoundExeption;
import com.lito.taller.repository.VehicleRepository;
import com.lito.taller.service.ClientService;
import com.lito.taller.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ClientService clientService;
    @Override
    public Set<VehicleDTO> getAllVehicle() {

        return vehicleRepository.findAll()
                .stream().map(
                        this::mapTuDTO
                ).collect(Collectors.toSet());
    }

    @Override
    public VehicleDTO getById(Long id) {

        return  mapTuDTO(vehicleRepository.findById(id).orElseThrow(
                        ()-> new ResourseNotFoundExeption(Vehicle.class.getName())
                ));
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapTuEntity(vehicleDTO);
        Vehicle vehicleCreated =
                vehicleRepository.save(vehicle);

        return mapTuDTO(vehicleCreated);
    }



    @Override
    /*
        Pienso, vamos a dejar que se pueda cambiar un vehiculo de cliente?
        En todo caso me parece que seria un endpoint diferente.
        Por eso no lo voy a dejar editar.
        Lo mismo que las notas, aca entiendo que no se editan.
     */
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {

        Vehicle vehicle = vehicleRepository.findById(vehicleDTO.getId()).orElseThrow(
                () -> new ResourseNotFoundExeption(
                        Vehicle.class.getName()));

        vehicle.setYear(vehicleDTO.getYear());
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setCar_number(vehicleDTO.getCar_number());
        vehicle.setModel(vehicleDTO.getModel());

        Vehicle vehicleSaved = vehicleRepository.save(vehicle);

        return mapTuDTO(vehicleSaved);
        
    }

    @Override
    public void deleteVehicle(Long id) {
         vehicleRepository.deleteById(
                vehicleRepository.findById(id).orElseThrow(
                        () -> new ResourseNotFoundExeption(
                                Vehicle.class.getName())
                        ).getId()
                );

    }

    VehicleDTO mapTuDTO(Vehicle vehicle){
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setYear(vehicleDTO.getYear());
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicleDTO.getModel());
        vehicleDTO.setCar_number(vehicle.getCar_number());
        vehicleDTO.setClientDTO(mapToDTO(vehicle.getClient()));

        return vehicleDTO;
    }

    private Vehicle mapTuEntity(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDTO.getId());
        vehicle.setYear(vehicleDTO.getYear());
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setCar_number(vehicleDTO.getCar_number());
        vehicle.setClient(mapToEntity(vehicleDTO.getClientDTO()));
        return vehicle;
    }

    private Client mapToEntity(ClientDTO clientDTO){
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setTel(clientDTO.getTel());
        client.setSummary(clientDTO.getSummary());
        return client;
    }

    private ClientDTO mapToDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setTel(client.getTel());
        clientDTO.setSummary(client.getSummary());
        return clientDTO;
    }

}
