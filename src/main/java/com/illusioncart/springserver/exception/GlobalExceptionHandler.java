package com.illusioncart.springserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookException.class)
    public ResponseEntity<BookErroDetails> bookExceptionHandler(BookException be, WebRequest req){
        BookErroDetails err = new BookErroDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(be.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<BookErroDetails>(err, HttpStatus.NOT_FOUND);
    }

    //The route is not available in server this will response
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BookErroDetails> otherExceptionHandler(Exception se, WebRequest req){


        BookErroDetails err= new BookErroDetails();
        err.setTimeStamp(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<BookErroDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
