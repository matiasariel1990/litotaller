package com.lito.taller.dto.work;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkDTO {

    long id;
    String summary;
    Date date_reception;
    Date date_pickup;


}
