package com.lito.taller.service.Impl;


import com.lito.taller.dto.VehicleDTO;
import com.lito.taller.dto.client.ClientDTO;
import com.lito.taller.dto.work.WorkDTO;
import com.lito.taller.dto.work.WorkDataDTO;
import com.lito.taller.entity.Client;
import com.lito.taller.entity.Vehicle;
import com.lito.taller.entity.Work;
import com.lito.taller.exeption.InvalidStatusException;
import com.lito.taller.exeption.ResourseNotFoundExeption;
import com.lito.taller.repository.VehicleRepository;
import com.lito.taller.repository.WorkRepository;
import com.lito.taller.entity.enums.WorkStatusEnum;
import com.lito.taller.service.WorkService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkRepository workRepository;


    @Autowired
    VehicleRepository vehicleRepository;

    //@Autowired
    //ClientRepository clientRepository;

    @Override
    public WorkDataDTO createWork(long vehicleId, WorkDTO workDTO) {

        Vehicle vehicle = vehicleRepository.getById(vehicleId);

        Work work = mapToEntity(workDTO);
        work.setVehicle(vehicle);
        work.setClient(work.getVehicle().getClient());
        work.setStatus(WorkStatusEnum.WAITING);
        workRepository.save(work);

        return mapToDataDTO(work);
    }

    @Override
    public WorkDTO updateWork(WorkDTO workDTO) {
        Work work = this.workRepository.findById(
                workDTO.getId()
        ).
        orElseThrow( () -> new ResourseNotFoundExeption(Work.class.getName()));
        work.setSummary(workDTO.getSummary());
        work.setDateReception(workDTO.getDateReception());
        work.setDateReception(workDTO.getDateReception());

        return mapToDTO( this.workRepository.save(work) );
    }

    @Override
    public Set<WorkDataDTO> getByVehicleId(long id) {
        System.out.println("service");
        return this.workRepository.findByVehicleId(id);
    }

    @Override
    public Set<WorkDataDTO> getByClientId(long id) {

        return this.workRepository.findByClientId(id);
    }

    @Override
    public WorkDataDTO changeStatus(long id, WorkStatusEnum workStatusTo) {
        Work work =  this.workRepository
                .findById(id)
                .orElseThrow( () -> new ResourseNotFoundExeption(Work.class.getName()));


        if(work.getStatus().authorize(workStatusTo)){
            work.setStatus(workStatusTo);
        } // aca va el else que dispara la exception cuando este desarrollado el ExceptionController

        return mapToDataDTO(this.workRepository.save(work));

    }


    private Work mapToEntity(WorkDTO workDTO){
        Work work = new Work();
        work.setSummary(workDTO.getSummary());
        work.setDateReception(workDTO.getDateReception());
        work.setDateReception(workDTO.getDatePickup());
        return work;
    }

    private WorkDTO mapToDTO(Work work){
        WorkDTO workDTO = new WorkDTO();
        workDTO.setSummary(work.getSummary());
        workDTO.setDateReception(work.getDateReception());
        workDTO.setDatePickup(work.getDatePickup());

        return workDTO;
    }

    private WorkDataDTO mapToDataDTO(Work work){
        WorkDataDTO workDataDTO = new WorkDataDTO();
        workDataDTO.setId(work.getId());
        workDataDTO.setSummary(work.getSummary());
        workDataDTO.setStatus(work.getStatus());
        workDataDTO.setDateReception(work.getDateReception());
        workDataDTO.setDatePickup(work.getDatePickup());
        workDataDTO.setVehicleDTO(mapToVehicleDTO(work.getVehicle()));
        workDataDTO.setClientDTO(new ClientDTO(work.getClient()));

        return workDataDTO;
    }

    VehicleDTO mapToVehicleDTO(Vehicle vehicle){
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setYear(vehicle.getYear());
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setCar_number(vehicle.getCar_number());
        vehicleDTO.setSummary(vehicle.getSummary());
        return vehicleDTO;
    }
}
