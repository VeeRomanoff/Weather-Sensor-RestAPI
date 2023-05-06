package com.neil.sensorAPI.utils;

public class SensorAlreadyExistsException extends RuntimeException {
    public SensorAlreadyExistsException(String message) {
        super(message);
    }
}

