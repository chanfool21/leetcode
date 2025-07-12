package designpattern.strategypattern.model;

import designpattern.strategypattern.strategy.DrivingStrategy;
import designpattern.strategypattern.strategy.SportyDrivingStrategy;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() {
        super(new SportyDrivingStrategy());
    }


}
