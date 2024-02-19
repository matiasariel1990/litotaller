package com.lito.taller.controller.Impl;

import com.lito.taller.controller.WorkController;
import com.lito.taller.dto.work.WorkDTO;
import com.lito.taller.dto.work.WorkDataDTO;
import com.lito.taller.entity.enums.WorkStatusEnum;
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
    public WorkDTO updateWork(WorkDTO workDTO) {

        return this.workService.updateWork(workDTO);
    }

    @Override
    public Set<WorkDataDTO> getByVehicleId(long id) {
        System.out.println("controller");
        return this.workService.getByVehicleId(id);
    }

    @Override
    public Set<WorkDataDTO> getByClientId(long id) {
        return this.workService.getByClientId(id);
    }

    @Override
    public WorkDataDTO updateWorkStatus(long id, WorkStatusEnum status){
            return workService.changeStatus(id, status);
    }
}
