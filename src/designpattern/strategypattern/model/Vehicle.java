package designpattern.strategypattern.model;

import designpattern.strategypattern.strategy.DrivingStrategy;

public class Vehicle {
    DrivingStrategy drivingStrategy;

    Vehicle(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
    }

    public void drive() {
        drivingStrategy.drive();
    }
}
