package com.erudio.exceptions.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private Date date;

    private String description;
}
