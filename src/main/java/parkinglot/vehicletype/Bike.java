package parkinglot.vehicletype;

import parkinglot.Vehicle;

public class Bike extends Vehicle {

    public Bike(String numberPlate) {
        super(numberPlate, VehicleType.BIKE);
    }
    
}