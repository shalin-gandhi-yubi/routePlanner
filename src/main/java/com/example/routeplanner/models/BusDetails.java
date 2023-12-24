package com.example.routeplanner.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BusDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String busRegNumber;
    private String busType;

    // getters and setters...
    public String getBusRegNumber() {
        return busRegNumber;
    }

    public void setBusRegNumber(String busRegNumber) {
        this.busRegNumber = busRegNumber;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }
}