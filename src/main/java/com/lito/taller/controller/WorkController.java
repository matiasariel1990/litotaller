package com.lito.taller.controller;

import com.lito.taller.dto.work.WorkDTO;
import com.lito.taller.dto.work.WorkDataDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("Work")
public interface WorkController {


    @PostMapping("/vehicle/{vehicleId}")
    public WorkDTO createWork(@PathVariable  long vehicleId,
                              @RequestBody WorkDTO workDTO);


    @PutMapping("/{Id}")
    public WorkDTO updateWork(@PathVariable  long Id,
                              @RequestBody WorkDTO workDTO);

    @GetMapping("/vehicle/{id}")
    public Set<WorkDataDTO> etByVehicleId(@PathVariable long id);

    @GetMapping("/client/{id}")
    public Set<WorkDataDTO> getByClientId(@PathVariable long id);

    @PutMapping("/queue/{id}")
    public void toQueue(@PathVariable long id);

    @PutMapping("/start/{id}")
    public void toStart(@PathVariable long id);

    @PutMapping("/Pause/{id}")
    public void toPause(@PathVariable long id);

    @PutMapping("/complete/{id}")
    public void toComplete(@PathVariable long id);

    @PutMapping("/deliver/{id}")
    public void toDeliver(@PathVariable long id);
}
