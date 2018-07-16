package com.thoughtworks.tdd.core;

import com.thoughtworks.tdd.exception.AllParkingLotFullException;
import com.thoughtworks.tdd.exception.CannotFindTheCarException;
import com.thoughtworks.tdd.exception.ParkingLotNotEmptyException;
import com.thoughtworks.tdd.exception.ParkingLotNotExistsException;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy{
    private List<ParkingLot> parkingLots = new ArrayList<>();
    private static int parkingNumber = 0;

    public ParkingBoy(){}
    public ParkingBoy(List<ParkingLot> _parkingLots) {
        parkingLots.addAll(_parkingLots);
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public void addParkingLot(int size, String name) {
        String id = String.format("%03d", parkingNumber++);
        parkingLots.add(new ParkingLot(size, name, id));
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
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

    public int lotsCount() {
        return parkingLots.size();
    }

    public int[] parkingLotSize(int i) {
        int[] space = new int[3];
        space[0] = parkingLots.get(i).getSize();
        space[1] = parkingLots.get(i).stopedCarsCounts();
        space[2] = parkingLots.get(i).lotsLeft();
        return space;
    }

    public void delLot(String id) {
        for(ParkingLot pl: parkingLots){
            if(pl.getId().equals(id)){
                if(pl.isEmpty()){
                    parkingLots.remove(pl);
                    return ;
                }else throw new ParkingLotNotEmptyException();
            }
        }throw new ParkingLotNotExistsException();
    }
}
