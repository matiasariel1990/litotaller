package com.lito.taller.controller;

import com.lito.taller.dto.work.WorkDTO;
import com.lito.taller.dto.work.WorkDataDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("Work")
public interface WorkController {


    @PostMapping("/vehicle/{vehicleId}")
    public WorkDataDTO createWork(@PathVariable  long vehicleId,
                              @RequestBody WorkDTO workDTO);


    @PutMapping("/{Id}")
    public WorkDTO updateWork(@PathVariable  long Id,
                              @RequestBody WorkDTO workDTO);

    @GetMapping("/vehicle/{id}")
    public Set<WorkDataDTO> getByVehicleId(@PathVariable long id);

    @GetMapping("/client/{id}")
    public Set<WorkDataDTO> getByClientId(@PathVariable long id);

    @PutMapping("/{id}/{status}")
    public void updateWorkStatus(@PathVariable long id, @PathVariable String status);


}
