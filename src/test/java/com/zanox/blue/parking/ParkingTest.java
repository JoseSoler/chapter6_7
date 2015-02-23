package com.zanox.blue.parking;

import org.junit.Assert;
import org.junit.Test;

public class ParkingTest {

    private Parking<Bike> bikesParking = new Parking<>();

    @Test(expected = PlaceAlreadyTakenException.class)
    public void shouldNotAllowTwoVehiclesSamePlace() throws PlaceAlreadyTakenException {
        bikesParking.parkVehicle("A1", new Bike("123", "Zbig"));
        bikesParking.parkVehicle("A1", new Bike("321", "Mike"));
    }

    @Test
    public void shouldContainTheParkedBike() throws PlaceAlreadyTakenException {
        bikesParking.parkVehicle("A2", new Bike("456", "Jose"));
        Assert.assertTrue("Bike not found!!!", bikesParking.checkParkedVehicle(new Bike("456", "Jose")));
    }

    @Test
    public void shouldGiveBackTheParkedBike() throws PlaceAlreadyTakenException {
        bikesParking.parkVehicle("A2", new Bike("456", "Jose"));
        Assert.assertNotNull("Bike not found!!!", bikesParking.unParkVehicle(new Bike("456", "Jose")));
    }

    @Test
    public void shouldBeEmptyAfterDestroying() throws PlaceAlreadyTakenException {
        bikesParking.parkVehicle("A1", new Bike("123", "Zbig"));
        bikesParking.parkVehicle("A2", new Bike("321", "Dragan"));
        bikesParking.parkVehicle("A3", new Bike("456", "Mike"));
        bikesParking.parkVehicle("A4", new Bike("956", "Jose"));

        bikesParking.destroyAllVehiclesInside();

        Assert.assertTrue("Parking is not empty.", bikesParking.getNumberOfParkedVehicles() == 0);
    }

}
