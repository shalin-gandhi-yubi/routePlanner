package com.example.routeplanner.service;

import com.example.routeplanner.models.BusRoute;
import com.example.routeplanner.repository.BusRouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteServiceImpl implements BusRouteService {
    private final BusRouteRepository busRouteRepository;

    public BusRouteServiceImpl(BusRouteRepository busRouteRepository) {
        this.busRouteRepository = busRouteRepository;
    }

    @Override
    public List<BusRoute> getAllRoutes() {
        return busRouteRepository.findAll();
    }

    @Override
    public BusRoute getRouteById(Long routeId) {
        return busRouteRepository.findById(routeId).orElse(null);
    }

    @Override
    public BusRoute saveRoute(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

    @Override
    public void deleteRoute(Long routeId) {
        busRouteRepository.deleteById(routeId);
    }
}
