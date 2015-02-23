package com.zanox.blue.parking;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.LinkedList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParkInTheStreetTest {

    private static List<Car> street = new LinkedList<>();

    @Test
    public void A_shouldParkVehiclesInTheStreet() {
        List anotherStreet = street;
        anotherStreet.add(new Bike("123", "Jose"));
        anotherStreet.add(new Car("1235", "Mike"));

    }

    @Test
    public void B_shouldGetVehiclesFromStreet() {
        for (Car car : street) {
            System.out.println(car);
        }
    }
}
