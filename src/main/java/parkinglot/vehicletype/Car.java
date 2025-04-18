package parkinglot.vehicletype;

import parkinglot.Vehicle;

public class Car extends Vehicle {
    
    public Car(String numberPlate) {
        super(numberPlate, VehicleType.CAR);
    }
    
}