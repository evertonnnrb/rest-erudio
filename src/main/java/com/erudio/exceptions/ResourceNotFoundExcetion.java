package com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcetion extends RuntimeException{
    public ResourceNotFoundExcetion(String e){
        super(e);
    }
}
