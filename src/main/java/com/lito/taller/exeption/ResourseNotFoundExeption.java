package com.lito.taller.exeption;

import org.apache.logging.log4j.message.StringFormattedMessage;

public class ResourseNotFoundExeption extends RuntimeException{

    String message;

    public ResourseNotFoundExeption(String className){
        message = className + " resourse doesn't exist.";
    }
}
