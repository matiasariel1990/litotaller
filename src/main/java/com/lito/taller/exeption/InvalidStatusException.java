package com.lito.taller.exeption;

import com.lito.taller.entity.enums.WorkStatusEnum;
import lombok.Data;

@Data
public class InvalidStatusException extends RuntimeException {

    String message;

    public InvalidStatusException(WorkStatusEnum statusFrom, WorkStatusEnum statusTo){
        message = "Invalid status change from " + statusFrom + " to " + statusTo;
    }


}
