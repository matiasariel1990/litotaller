package com.lito.taller.entity.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;


public enum WorkStatusEnum {
    WAITING(1, "QUEUED,STARTED"),
    QUEUED(2, "WAITING,STARTED"),
    STARTED(3, "QUEDED,PAUSED,COMPLETED"),
    PAUSED(4, "STARTED"),
    COMPLETED(5, "STARTED,DELIVERED"),
    DELIVERED(6, "COMPLETED,STARTED,QUEUED");

    @Getter
    final int id;
    @Getter
    final ArrayList<String> changeAuthFilter;

    private WorkStatusEnum(int id, String changeAuthFilter){
        this.id = id;
        this.changeAuthFilter = new ArrayList<String>(Arrays.asList(changeAuthFilter.split(",")));
    }

    public boolean authorize(WorkStatusEnum statusTo){
        return this.changeAuthFilter.contains(statusTo.toString());

    }


}
