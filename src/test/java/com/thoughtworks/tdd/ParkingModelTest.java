package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkingModelTest {
    @Test
    public void should_return_true_when_call_notFull_given_parkingLot_not_full(){
    // given
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingModel parkingModel = new ParkingModel(parkingBoy);
        when(parkingBoy.isAllFull()).thenReturn(false);
    // when
        boolean result = parkingModel.notFull();
    // then
        assertEquals(true, result);
    }
    
    @Test
    public void should_return_ticket_when_call_park_given_parking_lot_not_full(){
    // given
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingModel parkingModel = new ParkingModel(parkingBoy);
        Car car = mock(Car.class);
        when(car.getCarid()).thenReturn("testCar");
        when(parkingBoy.isAllFull()).thenReturn(false);
    // when
    // then
        try{
            parkingModel.park(car);
        }catch (AllParkingLotFullException allParkingLotFullException){
            fail("should return the ticket");
        }
    }
    @Test
    public void should_throw_exceptin_when_call_park_given_parking_lot_full(){
        // given
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingModel parkingModel = new ParkingModel(parkingBoy);
        Car car = mock(Car.class);
        when(car.getCarid()).thenReturn("testCar");
        when(parkingBoy.boyPark(car)).thenThrow(new AllParkingLotFullException());
        // when
        // then
        try{
            parkingModel.park(car);
            fail("should throw the exception");
        }catch (AllParkingLotFullException allParkingLotFullException){
        }
    }
}
