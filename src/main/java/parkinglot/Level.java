package parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parkinglot.vehicletype.VehicleType;

public class Level {

    // Member variables
    private int levelNumber;
    private int carCapacity;
    private int bikeCapacity;
    private int truckCapacity;
    private List<Spot> spots;
    private Map<Vehicle, Integer> parkedVehicles;

    // Private functions
    private void createSpots() {
        for (int i = 0; i < carCapacity; i++) {
            spots.add(new Spot(i, VehicleType.CAR));
        }
        for (int i = 0; i < bikeCapacity; i++) {
            spots.add(new Spot(i + carCapacity, VehicleType.BIKE));
        }
        for (int i = 0; i < truckCapacity; i++) {
            spots.add(new Spot(i + carCapacity + bikeCapacity, VehicleType.TRUCK));
        }
    } 

    // Public functions
    public Level(int level, int capacity) {
        levelNumber = level;
        carCapacity = (int)(0.4 * capacity);
        bikeCapacity = (int)(0.9 * capacity) - carCapacity;
        truckCapacity = capacity - (carCapacity + bikeCapacity);
        spots = new ArrayList<>(capacity);
        parkedVehicles = new HashMap<>();
        createSpots();
    }

    public boolean parkVehicle(Vehicle v) {
        if (parkedVehicles.containsKey(v)) return false;

        int start, end;
        if (v.type == VehicleType.CAR) {
            start = 0;
            end = carCapacity;
        } else if (v.type == VehicleType.BIKE) {
            start = carCapacity;
            end = bikeCapacity + carCapacity;
        } else {
            start = carCapacity + bikeCapacity;
            end = truckCapacity + carCapacity + bikeCapacity;
        }

        for (int i = start; i < end; i++) {
            if (spots.get(i).parkVehicle(v)) {
                parkedVehicles.put(v, spots.get(i).getSpotNumber());
                return true;
            }
        }

        return false;
    }

    public boolean unparkVehicle(Vehicle v) {
        if (!parkedVehicles.containsKey(v)) return false;

        int spot = parkedVehicles.get(v);
        if (spots.get(spot).unparkVehicle(v)) {
            parkedVehicles.remove(v);
            return true;
        }

        return false;
    }

    public void displayAvailability(VehicleType type) {
        int start, end;
        if (type == VehicleType.CAR) {
            start = 0;
            end = carCapacity;
        } else if (type == VehicleType.BIKE) {
            start = carCapacity;
            end = bikeCapacity + carCapacity;
        } else {
            start = carCapacity + bikeCapacity;
            end = truckCapacity + carCapacity + bikeCapacity;
        }

        for (int i = start; i < end; i++) {
            if (spots.get(i).isAvailable()) {
                System.out.println("Spot " + i + " at floor " + levelNumber + " is available.");
            }
        }
    }
}