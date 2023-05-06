package com.neil.sensorAPI.services;

import com.neil.sensorAPI.models.Sensor;
import com.neil.sensorAPI.repositories.SensorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void register(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    public Sensor findByName(String name) {
        return sensorRepository.findSensorByName(name).orElse(null);
    }

    public Optional<Sensor> checkSensorName(String name) {
        return sensorRepository.findSensorByName(name);
    }
}
