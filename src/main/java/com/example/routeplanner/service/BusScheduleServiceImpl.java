package com.example.routeplanner.service;

import com.example.routeplanner.models.BusSchedule;
import com.example.routeplanner.repository.BusScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {
    private final BusScheduleRepository busScheduleRepository;

    public BusScheduleServiceImpl(BusScheduleRepository busScheduleRepository) {
        this.busScheduleRepository = busScheduleRepository;
    }

    @Override
    public List<BusSchedule> getAllSchedules() {
        return busScheduleRepository.findAll();
    }

    @Override
    public BusSchedule getScheduleById(Long scheduleId) {
        return busScheduleRepository.findById(scheduleId).orElse(null);
    }

    @Override
    public BusSchedule saveSchedule(BusSchedule newBusSchedule) {
        Long busId = newBusSchedule.getBusId();
        Long routeId = newBusSchedule.getRouteId();
        LocalDateTime startTime = newBusSchedule.getStartTime();
        LocalDateTime endTime = newBusSchedule.getEndTime();

        // Check if there are overlapping schedules for the same bus and route
        List<BusSchedule> overlappingSchedules = busScheduleRepository
                .findOverlappingSchedules(busId, routeId, startTime, endTime);

        if (!overlappingSchedules.isEmpty()) {
            // Overlapping schedules found, handle accordingly (throw exception, return error response, etc.)
            // For simplicity, let's throw an exception here
            throw new SecurityException("Schedule overlaps with existing schedule(s).");
        }

        // No overlapping schedules, save the new schedule
        return busScheduleRepository.save(newBusSchedule);
    }

    @Override
    public void deleteSchedule(Long scheduleId) {
        busScheduleRepository.deleteById(scheduleId);
    }
}