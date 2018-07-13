package com.thoughtworks.tdd;

public class ParkingControl {
    private final ParkingView parkingView;
    private final ParkingModel parkingModel;


    public ParkingControl(ParkingView parkingView, ParkingModel parkingModel) {
        this.parkingView = parkingView;
        this.parkingModel = parkingModel;
    }

    public void start() {
        try {
            parkingView.start();
        }catch (InputNotValidException inputNotValidException){
            start();
        }

    }

}
