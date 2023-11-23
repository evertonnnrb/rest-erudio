package com.erudio.exceptions.handler;

import com.erudio.exceptions.ResourceNotFoundExcetion;
import com.erudio.exceptions.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception e, WebRequest req) {
        ExceptionResponse response = new ExceptionResponse(e.getMessage(), new Date(), req.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundExcetion.class)
    public final ResponseEntity<ExceptionResponse> handlerNotFoundException(Exception e, WebRequest req) {
        ExceptionResponse response = new ExceptionResponse(e.getMessage(), new Date(), req.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
