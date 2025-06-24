package com.lewis.iot_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Author: LaTonya S. Lewis
 * June 23, 2025
 */

@Component
public class KafkaProducer {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;


    public void sendRawData(String rawData) {
       // System.out.println("Sending raw data to Kafka: " + rawData);
        kafkaTemplate.send(topic, rawData);
    }
}
