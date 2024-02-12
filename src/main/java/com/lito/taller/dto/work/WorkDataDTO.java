package com.lito.taller.dto.work;

import com.lito.taller.entity.Client;
import com.lito.taller.entity.Vehicle;
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
    int status;
    Date dateReception;
    Date datePickaup;
    Vehicle vehicle;
    Client client;

}
