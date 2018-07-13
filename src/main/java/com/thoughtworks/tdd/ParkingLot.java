package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private int size;

//    private HashMap<Locate, Car> parkingSpace
    private HashMap<Ticket, Car> parkingCars = new HashMap<>();

    public ParkingLot(int _size) {
        size = _size;
    }

    public boolean isFull(){
        return parkingCars.size()>=size;
    }
    public int left() {
        return size - parkingCars.size();
    }

    public Ticket parking(Car car){
        if(!isFull()){
            Ticket ticket = new Ticket();
            parkingCars.put(ticket, car);
            return ticket;
        }
        else {
            throw new ParkingLotFullException();
//            return null;
        }
    }

    public Car unPark(Ticket ticket) {
//        if(parkingCars.containsKey(ticket))
//            return parkingCars.get(ticket);
//        else return null;
        String ticketUUID = ticket.getUUID();
        for(Ticket t: parkingCars.keySet()){
            if(t.getUUID().equals(ticketUUID)){
                return parkingCars.remove(t);
            }
        }
        throw new CannotFindTheCarException();
    }


}
