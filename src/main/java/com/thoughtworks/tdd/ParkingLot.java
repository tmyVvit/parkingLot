package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private int size;
    private String id;
    private String name;
    private HashMap<Ticket, Car> parkingCars = new HashMap<>();

    public ParkingLot(int _size) {
        size = _size;
        name = String.valueOf(size);
    }
    public ParkingLot(int _size, String _name, String _id) {
        size = _size;
        name = _name;
        id = _id;
    }

    public String getName(){return name;}
    public int getSize(){return size;}

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
        }
    }

    public Car unPark(Ticket ticket) {
        String ticketUUID = ticket.getUUID();
        for(Ticket t: parkingCars.keySet()){
            if(t.getUUID().equals(ticketUUID)){
                return parkingCars.remove(t);
            }
        }
        throw new CannotFindTheCarException();
    }


    public int lotsLeft() {
        return size-parkingCars.size();
    }

    public int stopedCarsCounts() {
        return parkingCars.size();
    }

    public String getId() {
        return id;
    }
    public boolean isEmpty(){
        return parkingCars.size() == 0;
    }
}
