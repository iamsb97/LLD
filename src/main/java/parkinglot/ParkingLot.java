package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // Member variables
    private int numLevels;
    List<Level> levels;

    // Private functions
    private void createLevels(int levelCapacity) {
        for (int i = 0; i < numLevels; i++) {
            levels.add(new Level(i, levelCapacity));
        }
    }

    // Public functions
    public ParkingLot(int num, int levelCap) {
        numLevels = num;
        levels = new ArrayList<>(numLevels);
        createLevels(levelCap);
    }

    public boolean parkVehicle(Vehicle v) {
        for (int i = 0; i < numLevels; i++) {
            if (levels.get(i).parkVehicle(v)) {
                return true;
            }
        }

        return false;
    }

    public boolean unparkVehicle(Vehicle v) {
        for (int i = 0; i < numLevels; i++) {
            if (levels.get(i).unparkVehicle(v)) {
                return true;
            }
        }

        return false;
    }
}