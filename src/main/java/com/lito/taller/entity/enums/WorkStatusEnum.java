package com.lito.taller.entity.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;


public enum WorkStatusEnum {
    WAITING( "QUEUED,STARTED"),
    QUEUED( "WAITING,STARTED"),
    STARTED( "QUEDED,PAUSED,COMPLETED"),
    PAUSED( "STARTED"),
    COMPLETED( "STARTED,DELIVERED"),
    DELIVERED( "COMPLETED,STARTED,QUEUED");

    @Getter
    final ArrayList<String> changeAuthFilter;

    private WorkStatusEnum( String changeAuthFilter){

        this.changeAuthFilter = new ArrayList<String>(Arrays.asList(changeAuthFilter.split(",")));
    }

    public boolean authorize(WorkStatusEnum statusTo){
        return this.changeAuthFilter.contains(statusTo.toString());

    }


}
