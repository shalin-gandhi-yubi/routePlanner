package com.example.routeplanner.repository;

import com.example.routeplanner.models.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {
    // Add custom queries if needed
    @Query("SELECT bs FROM BusSchedule bs " +
            "WHERE bs.busId = :busId " +
            "AND bs.routeId = :routeId " +
            "AND ((bs.startTime BETWEEN :startTime AND :endTime) OR (bs.endTime BETWEEN :startTime AND :endTime))")
    List<BusSchedule> findOverlappingSchedules(
            @Param("busId") Long busId,
            @Param("routeId") Long routeId,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime
    );
}