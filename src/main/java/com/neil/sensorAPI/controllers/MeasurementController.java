package com.neil.sensorAPI.controllers;

import com.neil.sensorAPI.DTO.MeasurementDTO;
import com.neil.sensorAPI.models.Measurement;
import com.neil.sensorAPI.services.MeasurementService;
import com.neil.sensorAPI.services.SensorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("/add")
    public ResponseEntity<MeasurementDTO> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO) {
        measurementService.save(measurementDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(measurementDTO);
    }

    @GetMapping("/rainyDaysCount")
    public Integer retrieveAllRainyDays() {
        return measurementService.retrieveAllRainyDays();
    }

    @GetMapping
    public List<Measurement> getAllMeasurements() {
        return measurementService.retrieveAllMeasurements();
    }
}
