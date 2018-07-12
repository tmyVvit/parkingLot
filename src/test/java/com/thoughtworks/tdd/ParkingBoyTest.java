package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

    @Test
    public void should_park_failed_when_call_boyPark_given_all_parking_lot_is_full(){
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLog(new ParkingLot(1));
        parkingBoy.boyPark(new Car(1));


        try {
            parkingBoy.boyPark(new Car(2));
            fail("should catch the exception");
        }catch (AllParkingLotFullException allParkingLotFullException){
        }
    }

    @Test
    public void should_park_to_second_parking_lot_when_call_boyPark_given_first_parking_lot_is_full(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot secondParkingLot = new ParkingLot(1);
        parkingBoy.addParkingLog(new ParkingLot(0));
        parkingBoy.addParkingLog(secondParkingLot);

        Note result = parkingBoy.boyPark(new Car(1));

        Note expect = new Note(1);

        assertEquals(expect, result);
    }
    
    @Test
    public void should_get_the_car_when_call_boyUnPack_given_parkingBoy_has_a_parking_lot_with_a_car_parked_input_note_correct(){
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLog(new ParkingLot(1));
        Car car = new Car(1);
        Note note = parkingBoy.boyPark(car);

        assertEquals(car, parkingBoy.boyUnPark(note));
    }

    @Test
    public void should_not_get_the_car_when_call_boyUnPack_given_parkingBoy_has_a_parking_lot_with_cars_parked_input_note_wrong(){
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLog(new ParkingLot(1));
        Car car = new Car(1);
        parkingBoy.boyPark(car);

        try {
            parkingBoy.boyUnPark(new Note(1));
            fail("should throw the CannotFindTheCarException");
        }catch (CannotFindTheCarException cannotFindTheCarException){
        }
    }
}
