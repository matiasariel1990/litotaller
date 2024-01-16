package com.lito.taller.service;



import com.lito.taller.dto.VehicleDTO;

import java.util.Set;

public interface VehicleService {
    public Set<VehicleDTO> getAllVehicle();

    public VehicleDTO getById(Long id);

    public VehicleDTO createVehicle(VehicleDTO clientDTO);

    public VehicleDTO updateVehicle(VehicleDTO clientDTO);

    public void deleteVehicle(Long id);


}
