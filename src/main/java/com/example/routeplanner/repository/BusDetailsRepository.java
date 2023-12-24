package com.example.routeplanner.repository;

// BusDetailsRepository.java
import com.example.routeplanner.models.BusDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BusDetailsRepository extends JpaRepository<BusDetails, Long> {
    // You can add custom query methods here if needed
    List<BusDetails> findByBusType(String busType);
}