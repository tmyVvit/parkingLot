package com.thoughtworks.tdd;

import java.util.Map;

public class Main {
    GetInput getInput;
    ParkingControl parkingControl;

    // init with ParkingBoy has 2 parking lot can park 2 cars and 1 car
    public Main(){
        getInput = new GetInput();
        parkingControl = new ParkingControl(new ParkingView(getInput), new ParkingModel());
    }

    public void start(){
        parkingControl.start();
    }

    public static void main(String[] args){
        Main main = new Main();
        main.start();
    }

}
