package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class ParkingBoyTest {
    @Test
    public void should_park_successful_when_call_boyPark_given_parkingBoy(){
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLog(new ParkingLot(1));

        Car car = new Car(1);
        try {
            parkingBoy.boyPark(car);
        }catch (ParkingLotFullException parkingLotFullException){
            fail("should park successful");
        }
    }
}
