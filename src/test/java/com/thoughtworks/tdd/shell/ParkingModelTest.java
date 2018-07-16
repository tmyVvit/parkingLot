package com.thoughtworks.tdd.shell;

import com.thoughtworks.tdd.core.Car;
import com.thoughtworks.tdd.core.ParkingBoy;
import com.thoughtworks.tdd.core.Ticket;
import com.thoughtworks.tdd.exception.AllParkingLotFullException;
import com.thoughtworks.tdd.exception.CannotFindTheCarException;
import com.thoughtworks.tdd.shell.ParkingModel;
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
    public void should_return_false_when_call_notFull_given_parkingLot_is_full(){
        // given
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingModel parkingModel = new ParkingModel(parkingBoy);
        when(parkingBoy.isAllFull()).thenReturn(true);
        // when
        boolean result = parkingModel.notFull();
        // then
        assertEquals(false, result);
    }
    
    @Test
    public void should_return_ticket_when_call_park_given_parking_lot_not_full(){
    // given
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingModel parkingModel = new ParkingModel(parkingBoy);
        Car car = mock(Car.class);
        when(car.getCarid()).thenReturn("testCar");
        when(parkingBoy.boyPark(car)).thenReturn(mock(Ticket.class));
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
    
    @Test
    public void should_return_car_when_call_unPark_given_valid_ticket(){
    // given
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingModel parkingModel = new ParkingModel(parkingBoy);
        Ticket ticket = mock(Ticket.class);
        when(ticket.getUUID()).thenReturn("test-uuid");
        when(parkingBoy.boyUnPark(ticket)).thenReturn(new Car());
    // when// then
        try{
            parkingModel.unPark(ticket);
        } catch (CannotFindTheCarException cannotFindTheCarException){
            fail("should get the car instead of throw exception");
        }
    }

    @Test
    public void should_throw_exception_when_call_unPark_given_invalid_ticket(){
        // given
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingModel parkingModel = new ParkingModel(parkingBoy);
        Ticket ticket = mock(Ticket.class);
        when(ticket.getUUID()).thenReturn("test-uuid");
        // when// then
        try{
            parkingModel.unPark(ticket);
        } catch (CannotFindTheCarException cannotFindTheCarException){
            fail("should get the car instead of throw exception");
        }
    }

    @Test
    public void should_get_parkingBoy_with_two_parking_lot_when_call_ParkingModel(){
    // given
        ParkingModel parkingModel = new ParkingModel();
    // when
        Car car1 = mock(Car.class);
        Car car2 = mock(Car.class);
        Car car3 = mock(Car.class);
        Car car4 = mock(Car.class);

        parkingModel.park(car1);
        parkingModel.park(car2);
        parkingModel.park(car3);
        // then
        try {
            parkingModel.park(car4);
            fail("should throw an exception");
        }catch (AllParkingLotFullException allParkingLotFullException){

        }
    }
}