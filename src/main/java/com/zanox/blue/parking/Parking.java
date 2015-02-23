package com.zanox.blue.parking;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Parking<T> {

    private Map<String, T> parkingArea = new HashMap<>();

    public void parkVehicle(String placeLabel, T vehicle) throws PlaceAlreadyTakenException {

        if (parkingArea.containsKey(placeLabel)) {
            throw new PlaceAlreadyTakenException();
        } else {
            parkingArea.put(placeLabel, vehicle);

        }
    }

    public T unParkVehicle(T vehicle){
        return parkingArea.get(vehicle);
    }

    public boolean checkParkedVehicle(T vehicle){
        return parkingArea.containsValue(vehicle);
    }

    /**
     * Use it at your own risk !!!
     */
    public void destroyAllVehiclesInside() {
        Iterator iterator = parkingArea.values().iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }
    }

    public int getNumberOfParkedVehicles() {
        return parkingArea.size();
    }

}
