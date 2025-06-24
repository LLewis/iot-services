package com.lewis.iot_service.controller;

import com.lewis.iot_service.dto.SensorRequest;
import com.lewis.iot_service.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: LaTonya S. Lewis
 * June 23, 2025
 */
@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping
    public ResponseEntity<String> receiveSensorData(@RequestBody SensorRequest request) {
        sensorService.processSensorData(request);
        return ResponseEntity.ok("Data received and processed");
    }
}
