package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ParkingBoyTest {
    @Test
    public void should_park_successful_when_call_boyPark_given_parkingBoy(){
        ParkingBoy parkingBoy = new ParkingBoy();

        ParkingLot parkingLot1 = mock(ParkingLot.class);
        parkingBoy.addParkingLot(parkingLot1);

        Car car = new Car(1);
        try {
            parkingBoy.boyPark(car);
            verify(parkingLot1).parking(car);
        }catch (ParkingLotFullException parkingLotFullException){
            fail("should park successful");
        }
    }

    @Test
    public void should_park_failed_when_call_boyPark_given_one_parking_lot_is_full(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = mock(ParkingLot.class);
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.boyPark(new Car(1));
        when(parkingLot.isFull()).thenReturn(true);

        try {
            parkingBoy.boyPark(new Car(2));
            fail("should catch the exception");
        }catch (AllParkingLotFullException allParkingLotFullException){
        }
    }

    @Test
    public void should_park_to_second_parking_lot_when_call_boyPark_given_first_parking_lot_is_full(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot secondParkingLot = mock(ParkingLot.class);
        ParkingLot firstParkingLot = mock(ParkingLot.class);
        parkingBoy.addParkingLot(firstParkingLot);
        parkingBoy.addParkingLot(secondParkingLot);
        when(firstParkingLot.isFull()).thenReturn(true);
        when(secondParkingLot.isFull()).thenReturn(false);

        Car car = new Car(1);
        parkingBoy.boyPark(car);

        verify(secondParkingLot).parking(car);

    }
    
    @Test
    public void should_get_the_car_when_call_boyUnPack_given_parkingBoy_has_a_parking_lot_with_a_car_parked_input_note_correct(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = mock(ParkingLot.class);
        parkingBoy.addParkingLot(parkingLot);
        Car car = new Car(1);
        Note note = new Note(1);

        when(parkingLot.parking(car)).thenReturn(note);
        when(parkingLot.unPark(note)).thenReturn(car);

        Note note1 = parkingBoy.boyPark(car);


        assertEquals(car, parkingBoy.boyUnPark(note1));
    }

    @Test
    public void should_not_get_the_car_when_call_boyUnPack_given_parkingBoy_has_a_parking_lot_with_cars_parked_input_note_wrong(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = mock(ParkingLot.class);
        parkingBoy.addParkingLot(parkingLot);
        Car car = new Car(1);
        Note note = new Note(1);
        when(parkingLot.parking(car)).thenReturn(note);
        when(parkingLot.unPark(note)).thenReturn(car);
        note = parkingBoy.boyPark(car);
        parkingBoy.boyUnPark(note);
        when(parkingLot.unPark(note)).thenReturn(null);
        try {
            parkingBoy.boyUnPark(note);
            fail("should throw the CannotFindTheCarException");
        }catch (CannotFindTheCarException cannotFindTheCarException){
        }
    }
}
