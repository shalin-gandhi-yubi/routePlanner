package com.example.routeplanner.service;

import com.example.routeplanner.models.BusRoute;

import java.util.List;

public interface BusRouteService {
    List<BusRoute> getAllRoutes();
    BusRoute getRouteById(Long routeId);
    BusRoute saveRoute(BusRoute busRoute);
    void deleteRoute(Long routeId);
}
