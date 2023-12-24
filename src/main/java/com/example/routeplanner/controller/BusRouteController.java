package com.example.routeplanner.controller;

import com.example.routeplanner.models.BusRoute;
import com.example.routeplanner.service.BusRouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class BusRouteController {
    private final BusRouteService busRouteService;

    public BusRouteController(BusRouteService busRouteService) {
        this.busRouteService = busRouteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusRoute>> getAllRoutes() {
        List<BusRoute> routes = busRouteService.getAllRoutes();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @GetMapping("/{routeId}")
    public ResponseEntity<BusRoute> getRouteById(@PathVariable Long routeId) {
        BusRoute route = busRouteService.getRouteById(routeId);
        if (route != null) {
            return new ResponseEntity<>(route, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<BusRoute> addRoute(@RequestBody BusRoute busRoute) {
        BusRoute savedRoute = busRouteService.saveRoute(busRoute);
        return new ResponseEntity<>(savedRoute, HttpStatus.CREATED);
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long routeId) {
        busRouteService.deleteRoute(routeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
