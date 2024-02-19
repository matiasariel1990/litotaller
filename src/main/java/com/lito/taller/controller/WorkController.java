package com.lito.taller.controller;

import com.lito.taller.dto.work.WorkDTO;
import com.lito.taller.dto.work.WorkDataDTO;
import com.lito.taller.entity.enums.WorkStatusEnum;
import com.lito.taller.exeption.InvalidStatusException;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("Work")
public interface WorkController {


    @PostMapping("/vehicle/{vehicleId}")
    public WorkDataDTO createWork(@PathVariable  long vehicleId,
                              @RequestBody WorkDTO workDTO);


    @PutMapping("")
    public WorkDTO updateWork(@RequestBody WorkDTO workDTO);

    @GetMapping("/vehicle/{id}")
    public Set<WorkDataDTO> getByVehicleId(@PathVariable long id);

    @GetMapping("/client/{id}")
    public Set<WorkDataDTO> getByClientId(@PathVariable long id);

    @PutMapping("/{id}/{status}")
    public WorkDataDTO updateWorkStatus(@PathVariable long id, @PathVariable WorkStatusEnum status) throws InvalidStatusException;


}
