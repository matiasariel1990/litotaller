package com.lito.taller.service.Impl;


import com.lito.taller.dto.VehicleDTO;
import com.lito.taller.dto.client.ClientDTO;
import com.lito.taller.dto.work.WorkDTO;
import com.lito.taller.dto.work.WorkDataDTO;
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
        return null;
    }

    @Override
    public Set<WorkDataDTO> getByVehicleId(long id) {
        return null;
    }

    @Override
    public Set<WorkDataDTO> getByClientId(long id) {
        return null;
    }

    @Override
    public WorkDataDTO changeStatus(long id, String status) {
        Work work =  this.workRepository
                .findById(id)
                .orElseThrow( () -> new ResourseNotFoundExeption(Work.class.getName()));

        WorkStatusEnum workStatusTo = WorkStatusEnum.valueOf(status);
        WorkStatusEnum workStatusFrom = work.getStatus();

        if(workStatusFrom.authorize(workStatusTo)){
            work.setStatus(workStatusTo);
        }

        return mapToDataDTO(this.workRepository.save(work));

    }


    private Work mapToEntity(WorkDTO workDTO){
        Work work = new Work();
        work.setSummary(workDTO.getSummary());
        work.setDateReception(workDTO.getDateReception());
        work.setDateReception(workDTO.getDatePickup());
        return work;
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
