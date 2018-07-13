package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy{
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy(){}
    public ParkingBoy(List<ParkingLot> _parkingLots) {
        parkingLots.addAll(_parkingLots);
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public ParkingLot getTheFirstNotFullParkingLot(){
        for (ParkingLot parkingLot: parkingLots) {
            if(!parkingLot.isFull()){
                return parkingLot;
            }
        }
        return null;
    }

    public boolean isAllFull(){
        for (ParkingLot parkingLot: parkingLots) {
            if(!parkingLot.isFull()){
                return false;
            }
        }
        return true;
    }
    public Ticket boyPark(Car car) {
        ParkingLot parkingLot = getTheFirstNotFullParkingLot();
        if(parkingLot != null){
            Ticket ticket = parkingLot.parking(car);
           //ticket.setParkingLot(parkingLot);
            return ticket;
        }
        else throw new AllParkingLotFullException();
        //return null;
    }


    public Car boyUnPark(Ticket ticket) {
        Car car = null;
        for(ParkingLot parkingLot: parkingLots){
            car = parkingLot.unPark(ticket);
            if(car != null){
                break;
            }
        }
        if(car == null){
            throw new CannotFindTheCarException();
        }
        return car;
    }
}
