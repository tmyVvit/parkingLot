package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy(){}


    public void addParkingLog(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public ParkingLot getTheParkingLot(){
        for (ParkingLot parkingLot: parkingLots) {
            if(!parkingLot.isFull()){
                return parkingLot;
            }
        }
        return null;
    }

    public Note boyPark(Car car) {
        ParkingLot parkingLot = getTheParkingLot();
        if(parkingLot != null){
            return parkingLot.parking(car);
        }
        throw new AllParkingLotFullException();
        //return null;
    }
}
