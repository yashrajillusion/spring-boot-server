package com.illusioncart.springserver.exception;

import lombok.Data;

import java.time.LocalDateTime;

public class BookErroDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public BookErroDetails() {
    }

    public BookErroDetails(LocalDateTime timeStamp, String message, String details) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
