package com.example.routeplanner.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusRoute {
    @Id
    private Long id;

    private String routeName;
    // other fields...

    // getters and setters...
    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}