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
            //ticket.setParkingLot(parkingLot);
            return parkingLot.parking(car);
        }
        else throw new AllParkingLotFullException();
        //return null;
    }


    public Car boyUnPark(Ticket ticket) {
        for(ParkingLot parkingLot: parkingLots){
            try{
                return parkingLot.unPark(ticket);
            }catch (CannotFindTheCarException cannotFindTheCarException){
                continue;
            }
        }
        throw new CannotFindTheCarException();
    }
}
