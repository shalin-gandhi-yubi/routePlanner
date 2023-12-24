package com.example.routeplanner.service;

import com.example.routeplanner.models.BusDetails;
import com.example.routeplanner.repository.BusDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusDetailsServiceImpl implements BusDetailsService {
    private final BusDetailsRepository busDetailsRepository;

    public BusDetailsServiceImpl(BusDetailsRepository busDetailsRepository) {
        this.busDetailsRepository = busDetailsRepository;
    }

    @Override
    public List<BusDetails> getAllBuses() {
        return busDetailsRepository.findAll();
    }

    @Override
    public BusDetails getBusById(Long busId) {
        return busDetailsRepository.findById(busId).orElse(null);
    }

    @Override
    public BusDetails saveBus(BusDetails busDetails) {
        return busDetailsRepository.save(busDetails);
    }

    @Override
    public void deleteBus(Long busId) {
        busDetailsRepository.deleteById(busId);
    }
}
