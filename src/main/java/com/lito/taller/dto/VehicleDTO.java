package com.lito.taller.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

}
