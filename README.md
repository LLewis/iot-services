# iot-service

A Spring Boot microservice receives IoT sensor data via REST API, stores metadata in a SQL DB using Hibernate, and forwards raw data to Kafka for downstream analytics in Spark.

How It Works:
*  IoT device sends POST request with JSON payload.
*  SensorController receives it and passes to SensorService.
*  Metadata (sensorId, location, timestamp, etc.) is saved in MySQL via JPA.
*  Raw sensor data is pushed to a Kafka iot-sensor-topic
*  Spark can consume from the Kafka topic for downstream analytics.
*  Create a iotdb Database in MySql



Steps to Execute:
1.  Run Spring Boot program
2.  Use Postman to test

   ```
   Postman Setup for Testing the API
  Open Postman


Click "New" > "HTTP Request"


Set the method to POST


In the URL field, enter:

 http://localhost:8080/api/sensors
Go to the "Headers" tab:


Add a header:

 Key: Content-Type
Value: application/json


Go to the "Body" tab:


Select "raw"


Choose JSON from the dropdown on the right


Paste this sample data:


{
  "sensorId": "TEMP-001",
  "location": "Atlanta-Lab1",
  "dataType": "temperature",
  "timestamp": "2025-06-23T14:20:00",
  "rawData": "28.5°C"
}

Click "Send"



Expected Response
{
  "status": "Data received and processed"
 }
```
