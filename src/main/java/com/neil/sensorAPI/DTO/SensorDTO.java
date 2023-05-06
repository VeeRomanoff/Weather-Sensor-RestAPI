package com.neil.sensorAPI.DTO;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SensorDTO {
    @Size(min = 3, max = 30, message = "The name of the sensor should be 3-30 symbols")
    private String name;
}
