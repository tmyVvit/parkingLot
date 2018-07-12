package com.thoughtworks.tdd;

public class Note {
    private int no;


    public Note(int _no){
        no = _no;
    }

//    public Note(int _no, ParkingLot _parkingLot){
//        no = _no;
//        parkingLot = _parkingLot;
//    }

    public int getNo(){
        return no;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Note){
            Note note = (Note)obj;
            return note.no == no ;//&& note.parkingLot == parkingLot;
        }
        return super.equals(obj);
    }

//    public ParkingLot getParkingLot() {
//        return parkingLot;
//    }

//    public void setParkingLot(ParkingLot _parkingLot) {
//        parkingLot = _parkingLot;
//    }
}
