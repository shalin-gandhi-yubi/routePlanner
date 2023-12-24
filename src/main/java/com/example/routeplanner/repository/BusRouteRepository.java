package com.example.routeplanner.repository;

import com.example.routeplanner.models.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {
    // Add custom queries if needed
}
