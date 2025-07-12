package designpattern.strategypattern.model;

import designpattern.strategypattern.strategy.DrivingStrategy;
import designpattern.strategypattern.strategy.NormalDrivingStrategy;

public class PassengerVehicle extends Vehicle{

    public PassengerVehicle() {
        super(new NormalDrivingStrategy());
    }
}
