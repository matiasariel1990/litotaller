package com.lito.taller.dto.work;

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
    String status;
    Date date_reception;
    Date date_pickaup;

    Entity entity;

}
