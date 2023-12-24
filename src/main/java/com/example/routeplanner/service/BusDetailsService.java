package com.example.routeplanner.service;

import com.example.routeplanner.models.BusDetails;

import java.util.List;

public interface BusDetailsService {
    List<BusDetails> getAllBuses();
    BusDetails getBusById(Long busId);
    BusDetails saveBus(BusDetails busDetails);
    void deleteBus(Long busId);
}

