package com.lito.taller.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


@Repository

public enum WorkStatusRepository {
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

    private WorkStatusRepository(int id, String changeAuthFilter){
        this.id = id;
        this.changeAuthFilter = new ArrayList<String>(Arrays.asList(changeAuthFilter.split(",")));
    }



}
