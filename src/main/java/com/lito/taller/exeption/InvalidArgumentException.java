package com.lito.taller.exeption;

public class InvalidArgumentException extends RuntimeException{
    String message;

    public InvalidArgumentException(String arg){
        message = "Invalid argument: " + arg;
    }
}
