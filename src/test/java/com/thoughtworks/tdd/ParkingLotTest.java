package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ParkingLotTest {
    @Test
    public void should_return_note1_when_call_parking_given_input_car1(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car(1);
        Note note1 = new Note(1);
        //when
        try {
            Note result = parkingLot.parking(car1);
            assertEquals(note1, result);
        }catch (ParkingLotFullException parkingLotFullExcetion){
            fail("you can't park car when parking lot is full");
        }
    }

    @Test
    public void should_throw_ParkingLotFullException_when_call_parking_given_parking_lot_is_full(){
        ParkingLot parkingLot = new ParkingLot(2);
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);
        parkingLot.parking(car1);
        parkingLot.parking(car2);

        try{
            parkingLot.parking(car3);
            fail("it should throw exception when parking lot is full");
        }catch (ParkingLotFullException parkingLotFullException){
        }
    }

    @Test
    public void should_park_success_when_a_full_parking_lot_unParked(){
        ParkingLot parkingLot = new ParkingLot(2);
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);
        Note note1 = parkingLot.parking(car1);
        parkingLot.parking(car2);

        parkingLot.unPark(note1);
        try{
            parkingLot.parking(car3);
        }catch (ParkingLotFullException parkingLotFullException){
            fail("it should park successful");
        }
    }

    @Test
    public void should_return_car_when_call_unPark_given_input_note_in_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car(1);
        Note note1 = parkingLot.parking(car1);

        Car result = parkingLot.unPark(note1);

        assertEquals(car1, result);
    }

    @Test
    public void should_return_null_when_call_unPark_given_input_note_not_in_pakingLot() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Note note1 = parkingLot.parking(car1);
        Note note2 = new Note(car2.getCarid());

        Car result = parkingLot.unPark(note2);

        assertEquals(null, result);
    }


    @Test
    public void should_return_emptysize_when_call_left(){
        ParkingLot parkingLot = new ParkingLot(5);
        Car car1 = new Car(1);
        Car car2 = new Car(2);

        parkingLot.parking(car1);
        parkingLot.parking(car2);

        int result = parkingLot.left();

        assertEquals(3, result);
    }
}
