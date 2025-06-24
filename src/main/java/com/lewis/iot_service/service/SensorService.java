package com.lewis.iot_service.service;

import com.lewis.iot_service.dto.SensorRequest;
import com.lewis.iot_service.entity.SensorMetadata;
import com.lewis.iot_service.kafka.KafkaProducer;
import com.lewis.iot_service.repository.SensorRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: LaTonya S. Lewis
 * June 23, 2025
 */
@Service
public class SensorService {

    private final SensorRepository repository;

    private final KafkaProducer kafkaProducer;

    public SensorService(SensorRepository repository, KafkaProducer kafkaProducer) {
        this.repository = repository;
        this.kafkaProducer = kafkaProducer;
    }

    public void processSensorData(SensorRequest request) {
        // Save metadata to SQL DB
        SensorMetadata meta = new SensorMetadata();
        meta.setSensorId(request.sensorId);
        meta.setLocation(request.location);
        meta.setTimestamp(request.timestamp);
        meta.setDataType(request.dataType);
        repository.save(meta);

        // Forward raw data to Kafka
        kafkaProducer.sendRawData(request.rawData);
    }


}
