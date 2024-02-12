package com.lito.taller.service.Impl;

import com.lito.taller.dto.VehicleDTO;
import com.lito.taller.dto.work.WorkDTO;
import com.lito.taller.dto.work.WorkDataDTO;
import com.lito.taller.entity.Vehicle;
import com.lito.taller.entity.Work;
import com.lito.taller.repository.WorkRepository;
import com.lito.taller.repository.WorkStatusRepository;
import com.lito.taller.service.VehicleService;
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
    VehicleService vehicleService;

    @Override
    public WorkDataDTO createWork(long vehicleId, WorkDTO workDTO) {

        VehicleDTO vehicleDTO = vehicleService.getById(vehicleId);

        Work work = mapToEntity(workDTO);
        work.setVehicle(mapToVehicleEntity(vehicleDTO));
        work.setClient(work.getVehicle().getClient());
        work.setStatus(WorkStatusRepository.WAITING.ordinal());
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
    public void changeStatus(long id, String status) {

    }

    private Vehicle mapToVehicleEntity(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDTO.getId());
        vehicle.setYear(vehicleDTO.getYear());
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setCar_number(vehicleDTO.getCar_number());
        return vehicle;
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
        workDataDTO.setDatePickaup(work.getDatePickup());
        workDataDTO.setVehicle(work.getVehicle());
        workDataDTO.setClient(work.getClient());

        return workDataDTO;
    }

}
