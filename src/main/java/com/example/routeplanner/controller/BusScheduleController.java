package com.example.routeplanner.controller;

import com.example.routeplanner.models.BusSchedule;
import com.example.routeplanner.service.BusScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class BusScheduleController {
    private final BusScheduleService busScheduleService;

    public BusScheduleController(BusScheduleService busScheduleService) {
        this.busScheduleService = busScheduleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusSchedule>> getAllSchedules() {
        List<BusSchedule> schedules = busScheduleService.getAllSchedules();
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<BusSchedule> getScheduleById(@PathVariable Long scheduleId) {
        BusSchedule schedule = busScheduleService.getScheduleById(scheduleId);
        if (schedule != null) {
            return new ResponseEntity<>(schedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<BusSchedule> addSchedule(@RequestBody BusSchedule busSchedule) {
        BusSchedule savedSchedule = busScheduleService.saveSchedule(busSchedule);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        busScheduleService.deleteSchedule(scheduleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
