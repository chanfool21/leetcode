package designpattern.strategypattern.strategy;

public class SportyDrivingStrategy implements DrivingStrategy{
    @Override
    public void drive() {
        System.out.println("Drives sportingly");
    }
}
