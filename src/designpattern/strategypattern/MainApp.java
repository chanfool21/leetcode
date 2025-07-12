package designpattern.strategypattern;

import designpattern.strategypattern.model.PassengerVehicle;
import designpattern.strategypattern.model.SportsVehicle;
import designpattern.strategypattern.model.Vehicle;

public class MainApp {
    public static void main(String[] args) {
        Vehicle normalVehicle = new PassengerVehicle();
        Vehicle sportsVehicle = new SportsVehicle();

        normalVehicle.drive();
        sportsVehicle.drive();
    }
}
