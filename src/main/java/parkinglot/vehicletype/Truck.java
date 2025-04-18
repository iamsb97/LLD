package parkinglot.vehicletype;

import parkinglot.Vehicle;

public class Truck extends Vehicle {

    public Truck (String numberPlate) {
        super(numberPlate, VehicleType.TRUCK);
    }

}