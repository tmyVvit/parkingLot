package com.thoughtworks.tdd;

public class Note {
    private int no;
    private ParkingLot parkingLot;
    public Note(int _no){
        no = _no;
    }
    public Note(int _no, ParkingLot _parkingLot){
        no = _no;
        parkingLot = _parkingLot;
    }

    public int getNo(){
        return no;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Note){
            Note note = (Note)obj;
            return note.no == no;
        }
        return super.equals(obj);
    }
}
