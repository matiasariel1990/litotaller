package com.lito.taller.dto;



import com.lito.taller.dto.client.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    long id;

    String car_number;

    String brand;

    String model;

    int year;

    String summary;

    ClientDTO clientDTO;
}
