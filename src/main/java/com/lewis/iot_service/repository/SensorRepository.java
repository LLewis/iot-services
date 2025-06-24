package com.lewis.iot_service.repository;

import com.lewis.iot_service.entity.SensorMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: LaTonya S. Lewis
 * June 23, 2025
 */
@Repository
public interface SensorRepository extends JpaRepository<SensorMetadata, Long> {
}
