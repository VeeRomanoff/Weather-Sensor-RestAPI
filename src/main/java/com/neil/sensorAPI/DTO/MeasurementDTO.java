package com.neil.sensorAPI.DTO;

import com.neil.sensorAPI.models.Sensor;
import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MeasurementDTO {

    @DecimalMin(value = "-100", message = "Temperature value is invalid (<100)")
    @DecimalMax(value = "100", message = "Temperature is invalid (>100)")
    @NotNull(message = "field 'Value' cannot be empty")
    private Double value;

    @Column(name = "rain")
    @NotNull(message = "field 'Rain' cannot be empty")
    private Boolean rain;

    @NotNull(message = "Field 'Sensor' cannot be empty")
    private Sensor sensor;
}
