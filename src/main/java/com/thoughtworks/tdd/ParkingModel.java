package com.thoughtworks.tdd;

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

    public void addLot(int size, String name) {
        parkingBoy.addParkingLot(size, name);
    }

    public List<ParkingLot> getParkinglots() {
        return parkingBoy.getParkingLots();
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

    public int parkingLotsCount() {
        return parkingBoy.lotsCount();
    }

    public int[] parkingLotsize(int i) {
        return parkingBoy.parkingLotSize(i);
    }

    public void delLot(String id) {
        parkingBoy.delLot(id);
    }
}
