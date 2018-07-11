package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private int size;

//    private HashMap<Locate, Car> parkingSpace
    private HashMap<Note, Car> parkingCars = new HashMap<>();

    public ParkingLot(int _size) {
        size = _size;
    }

    public boolean isFull(){
        return parkingCars.size()>=size;
    }
    public int left() {
        return size - parkingCars.size();
    }

    public Note parking(Car car){
        if(!isFull()){
            Note note = new Note(car.getCarid());
            parkingCars.put(note, car);
            return note;
        }
        else {
            throw new ParkingLotFullException();
//            return null;
        }
    }

    public Car unPark(Note note) {
//        if(parkingCars.containsKey(note))
//            return parkingCars.get(note);
//        else return null;
        return parkingCars.remove(note);
    }


}
