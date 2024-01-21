package com.lito.taller.service;



import com.lito.taller.dto.VehicleDTO;

import java.util.Set;

public interface VehicleService {
    public Set<VehicleDTO> getAllVehicle();

    public VehicleDTO getById(Long id);

    public VehicleDTO createVehicle(VehicleDTO vehicleDTO);

    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO);

    public void deleteVehicle(Long id);


}
