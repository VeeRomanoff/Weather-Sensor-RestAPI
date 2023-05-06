package com.neil.sensorAPI.utils;

import com.neil.sensorAPI.models.Sensor;
import com.neil.sensorAPI.services.SensorService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.neil.sensorAPI.DTO.SensorDTO;

@Component
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SensorDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Sensor sensor = (Sensor) o;

        if (sensorService.checkSensorName(sensor.getName()).isPresent()) {
            errors.rejectValue("name", "Sensor with this name already exists!");
        }
    }
}
