package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private int size;
    private HashMap<Note, Car> parkingCars = new HashMap<>();

    public ParkingLot(int _size) {
        size = _size;
    }

    public boolean isFull(){
        return parkingCars.size()>=size;
    }

    public Note parking(Car car){
        if(!isFull()){
            Note note = new Note(car.getCarid());
            parkingCars.put(note, car);
            return note;
        }
        else return null;
    }

    public Car carGo(Note note) {
//        if(parkingCars.containsKey(note))
//            return parkingCars.get(note);
//        else return null;
        return parkingCars.getOrDefault(note, null);
    }

    public int left() {
        return size-parkingCars.size();
    }
}
