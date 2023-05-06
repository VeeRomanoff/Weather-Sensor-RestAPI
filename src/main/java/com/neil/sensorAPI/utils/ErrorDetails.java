package com.neil.sensorAPI.utils;

import lombok.Data;
import java.time.LocalTime;

@Data
public class ErrorDetails {
    private String message;
    private String details;
    private LocalTime timestamp;

    public ErrorDetails(String message, String details, LocalTime timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    public ErrorDetails() {
    }
}
