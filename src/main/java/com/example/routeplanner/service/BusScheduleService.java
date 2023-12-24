package com.example.routeplanner.service;

import com.example.routeplanner.models.BusSchedule;

import java.util.List;

public interface BusScheduleService {
    List<BusSchedule> getAllSchedules();
    BusSchedule getScheduleById(Long scheduleId);
    BusSchedule saveSchedule(BusSchedule busSchedule);
    void deleteSchedule(Long scheduleId);
}