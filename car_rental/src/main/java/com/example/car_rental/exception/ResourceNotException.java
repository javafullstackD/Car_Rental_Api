package com.example.car_rental.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotException extends RuntimeException {
    public  ResourceNotException(String message){
        super(message);
    }
}
