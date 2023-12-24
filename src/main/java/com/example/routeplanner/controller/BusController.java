package com.example.routeplanner.controller;

import com.example.routeplanner.models.BusDetails;
import com.example.routeplanner.service.BusDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {
    private final BusDetailsService busDetailsService;

    public BusController(BusDetailsService busDetailsService) {
        this.busDetailsService = busDetailsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusDetails>> getAllBuses() {
        List<BusDetails> buses = busDetailsService.getAllBuses();
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    @GetMapping("/{busId}")
    public ResponseEntity<BusDetails> getBusById(@PathVariable Long busId) {
        BusDetails bus = busDetailsService.getBusById(busId);
        if (bus != null) {
            return new ResponseEntity<>(bus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<BusDetails> addBus(@RequestBody BusDetails busDetails) {
        BusDetails savedBus = busDetailsService.saveBus(busDetails);
        return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
    }

    @DeleteMapping("/{busId}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long busId) {
        busDetailsService.deleteBus(busId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}