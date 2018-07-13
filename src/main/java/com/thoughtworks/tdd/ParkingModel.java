package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingModel {
    private ParkingBoy parkingBoy;

    public ParkingModel(ParkingBoy _parkingBoy) {
        parkingBoy = _parkingBoy;
    }
    public ParkingModel(){
       parkingBoy = new ParkingBoy();
       parkingBoy.addParkingLot(new ParkingLot(2));
       parkingBoy.addParkingLot(new ParkingLot(1));
    }

    public Ticket park(Car car){
        try{
            Ticket ticket = parkingBoy.boyPark(car);
            return ticket;
        }catch (AllParkingLotFullException allParkingLotFullException){
            throw allParkingLotFullException;
        }
    }

    public boolean notFull() {
        return !parkingBoy.isAllFull();
    }
}
