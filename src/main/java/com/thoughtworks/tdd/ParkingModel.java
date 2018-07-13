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
        return parkingBoy.boyPark(car);
    }

    public boolean notFull() {
        return !parkingBoy.isAllFull();
    }

    public Car unPark(Ticket ticket) {
        return parkingBoy.boyUnPark(ticket);
    }
}
