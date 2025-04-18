package parkinglot;

import parkinglot.vehicletype.VehicleType;

public class Spot {

    // Member variables
    private int spotNumber;
    private Vehicle vehicle;
    private VehicleType type;

    // Public functions
    public Spot(int spot, VehicleType typ) {
        spotNumber = spot;
        vehicle = null;
        type = typ;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean parkVehicle(Vehicle v) {
        if (vehicle == null) {
            vehicle = v;
            return true;
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle v) {
        if (vehicle != null) {
            if (vehicle.numberPlate == v.numberPlate) {
                vehicle = null;
                return true;
            }
        }
        return false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getType() {
        return type;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}