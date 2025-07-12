package designpattern.strategypattern.strategy;

public class NormalDrivingStrategy implements DrivingStrategy{
    @Override
    public void drive() {
        System.out.println("Drives normally");
    }
}
