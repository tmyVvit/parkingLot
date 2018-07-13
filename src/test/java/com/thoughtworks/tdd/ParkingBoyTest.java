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

        Car car = new Car();
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
        when(parkingLot.isFull()).thenReturn(false, true);

        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.boyPark(new Car());


        try {
            parkingBoy.boyPark(new Car());
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
        when(firstParkingLot.isFull()).thenReturn(false, true);
        when(secondParkingLot.isFull()).thenReturn(false);

        Car car = new Car();
        Car car2 = new Car();
        parkingBoy.boyPark(car);
        parkingBoy.boyPark(car2);

        verify(secondParkingLot).parking(car2);

    }
    
    @Test
    public void should_get_the_car_when_call_boyUnPack_given_parkingBoy_has_a_parking_lot_with_a_car_parked_input_note_correct(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = mock(ParkingLot.class);
        parkingBoy.addParkingLot(parkingLot);
        Car car = new Car();
        Ticket ticket = new Ticket();

        when(parkingLot.parking(car)).thenReturn(ticket);

        when(parkingLot.unPark(ticket)).thenReturn(car);

        Ticket ticket1 = parkingBoy.boyPark(car);


        assertEquals(car, parkingBoy.boyUnPark(ticket1));
    }

    @Test
    public void should_not_get_the_car_when_call_boyUnPack_given_parkingBoy_has_a_parking_lot_with_cars_parked_input_note_wrong(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = mock(ParkingLot.class);
        parkingBoy.addParkingLot(parkingLot);
        Car car = new Car();
        Ticket ticket = new Ticket();
        when(parkingLot.parking(car)).thenReturn(ticket);
        when(parkingLot.unPark(ticket)).thenReturn(car);
        ticket = parkingBoy.boyPark(car);
        parkingBoy.boyUnPark(ticket);
        when(parkingLot.unPark(ticket)).thenReturn(null);
        try {
            parkingBoy.boyUnPark(ticket);
            fail("should throw the CannotFindTheCarException");
        }catch (CannotFindTheCarException cannotFindTheCarException){
        }
    }
    

}
