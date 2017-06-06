package com.example.adam.carsregister;

/**
 * Created by Adam on 12.05.2017.
 */

public class Car {
    private String name;
    private int numberOfSeats;
    private boolean isRacingCar;

    public Car(String name, int numberOfSeats, boolean isRacingCar) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.isRacingCar = isRacingCar;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isRacingCar() {
        return isRacingCar;
    }
}
