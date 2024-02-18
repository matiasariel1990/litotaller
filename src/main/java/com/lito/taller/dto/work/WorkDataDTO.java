package com.lito.taller.dto.work;

import com.lito.taller.dto.VehicleDTO;
import com.lito.taller.dto.client.ClientDTO;
import com.lito.taller.entity.Client;
import com.lito.taller.entity.Vehicle;
import com.lito.taller.entity.enums.WorkStatusEnum;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkDataDTO {
    long id;
    String summary;
    WorkStatusEnum status;
    Date dateReception;
    Date datePickup;
    VehicleDTO vehicleDTO;
    ClientDTO clientDTO;

}
