package com.lito.taller.controller.Impl;

import com.lito.taller.controller.WorkController;
import com.lito.taller.dto.work.WorkDTO;
import com.lito.taller.dto.work.WorkDataDTO;
import com.lito.taller.exeption.InvalidStatusException;
import com.lito.taller.service.VehicleService;
import com.lito.taller.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class WorkControllerImpl implements WorkController {

    @Autowired
    WorkService workService;
    @Override
    public WorkDataDTO createWork(long vehicleId, WorkDTO workDTO) {
        return workService.createWork(vehicleId, workDTO);
    }

    @Override
    public WorkDTO updateWork(long Id, WorkDTO workDTO) {
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
    public WorkDataDTO updateWorkStatus(long id, String status){
            return workService.changeStatus(id, status.toUpperCase());
    }
}
