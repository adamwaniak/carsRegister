package com.example.adam.carsregister;

/**
 * Created by Adam on 12.05.2017.
 */

public class Truck {
    String name;
    String capacity;
    String brand;
    String rating;

    public Truck(String name, String capacity, String brand, String rating) {
        this.name = name;
        this.capacity = capacity;
        this.brand = brand;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getBrand() {
        return brand;
    }

    public String getRating() {
        return rating;
    }
}
