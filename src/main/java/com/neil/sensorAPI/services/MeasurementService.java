package com.neil.sensorAPI.services;

import com.neil.sensorAPI.DTO.MeasurementDTO;
import com.neil.sensorAPI.models.Measurement;
import com.neil.sensorAPI.models.Sensor;
import com.neil.sensorAPI.repositories.MeasurementRepository;
import com.neil.sensorAPI.utils.SensorNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final SensorService sensorService;
    private final MeasurementRepository measurementRepository;

    public MeasurementService(SensorService sensorService, MeasurementRepository measurementRepository) {
        this.sensorService = sensorService;
        this.measurementRepository = measurementRepository;
    }

    @Transactional
    public void save(MeasurementDTO measurementDTO) {
        Measurement measurement = new Measurement();
        Sensor sensor = sensorService.findByName(measurementDTO.getSensor().getName());

        if (sensor == null)
            throw new SensorNotFoundException("Sensor not found");

        measurement.setValue(measurementDTO.getValue());
        measurement.setRain(measurementDTO.getRain());
        measurement.setSensor(sensor);
        measurementRepository.save(measurement);
    }

    public List<Measurement> retrieveAllMeasurements() {
        return measurementRepository.findAll();
    }

    public Integer retrieveAllRainyDays() {
        List<Measurement> rainyDays = measurementRepository.findByRainTrue();
        return rainyDays.size();
    }

    @Transactional
    public void sendThousandRequests(String sensorName) {
        Sensor sensor = sensorService.findByName(sensorName);

        Random random = new Random();
        RestTemplate restTemplate = new RestTemplate();

        Double value = null;
        Boolean rain = null;
        Map<String, Object> jsonToSend = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            value = random.nextDouble(-100, 100);
            rain = random.nextBoolean();
            jsonToSend.put("value", value);
            jsonToSend.put("rain", rain);
            jsonToSend.put("sensor", sensor);
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToSend);
            restTemplate.postForEntity("http://localhost:8080/measurements/add", request, String.class);
        }
    }
}
