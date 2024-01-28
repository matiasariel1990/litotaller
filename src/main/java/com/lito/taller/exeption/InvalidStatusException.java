package com.lito.taller.exeption;

public class InvalidStatusException {

    String message;

    public InvalidStatusException(String statusFrom, String statusTo){
        message = "Invalid status change from " + statusFrom + " to " + statusTo;
    }


}
