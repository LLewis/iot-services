package com.lewis.iot_service.dto;

import java.time.LocalDateTime;

/**
 * Author: LaTonya S. Lewis
 * June 23, 2025
 */
public class SensorRequest {

    public String sensorId;
    public String location;
    public String dataType;
    public LocalDateTime timestamp;
    public String rawData;  // Actual reading
}
