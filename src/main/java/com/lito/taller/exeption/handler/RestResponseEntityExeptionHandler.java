package com.lito.taller.exeption.handler;

import com.lito.taller.dto.response.ResponseErrorDto;
import com.lito.taller.exeption.ResourseNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExeptionHandler {

    @ExceptionHandler( ResourseNotFoundExeption.class)
    public ResponseEntity<ResponseErrorDto> handlerResourseNotFoundException(
            Exception ex, WebRequest webRequest){
        ResponseErrorDto responseBody = new ResponseErrorDto(
                ex.getMessage(), "123"
        ) ;
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

}
