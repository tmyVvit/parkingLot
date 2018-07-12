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
            Note note = parkingLot.parking(car);
           //note.setParkingLot(parkingLot);
            return note;
        }
        else throw new AllParkingLotFullException();
        //return null;
    }

//    public Car boyUnParkOld(Note note) {
//        ParkingLot parkingLot = note.getParkingLot();
//        if(parkingLot != null)
//            return parkingLot.unPark(note);
//        return null;
//    }

    public Car boyUnPark(Note note) {
        Car car = null;
        for(ParkingLot parkingLot: parkingLots){
            car = parkingLot.unPark(note);
            if(car != null){
                break;
            }
        }
        return car;
    }
}
