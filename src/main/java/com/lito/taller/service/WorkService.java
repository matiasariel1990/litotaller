package com.lito.taller.service;

import com.lito.taller.dto.work.WorkDTO;
import com.lito.taller.dto.work.WorkDataDTO;

import java.util.Set;

public interface WorkService {

    public WorkDataDTO createWork(long vehicleId, WorkDTO workDTO);

    public WorkDTO updateWork(WorkDTO workDTO);

    public Set<WorkDataDTO> getByVehicleId(long id);

    public Set<WorkDataDTO> getByClientId(long id);

    public void changeStatus(long id, String status);



}
