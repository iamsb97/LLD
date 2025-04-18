package parkinglot;

import parkinglot.vehicletype.VehicleType;

public abstract class Vehicle {

    // Member variables
    protected String numberPlate;
    protected VehicleType type;
    
    // Public functions
    public Vehicle(String number, VehicleType typ) {
        numberPlate = number;
        type = typ;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public VehicleType getType() {
        return type;
    }
}
