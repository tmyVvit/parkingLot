package com.thoughtworks.tdd;

import java.util.Map;

public class Main {
    GetInput getInput;
//    ParkingControl parkingControl;

    // init with ParkingBoy has 2 parking lot can park 2 cars and 1 car
    public Main() {
        getInput = new GetInput();
//        parkingControl = new ParkingControl(new ParkingView(), new ParkingModel(), getInput, "main");
    }



    public static void main(String[] args) {
        Main main = new Main();
        Request request = new Request();
        Router router = new Router("main", new ParkingModel());
        while (true) {

            router.printPage();
            String command = main.getInput.get();
            request.setCommand(command);
            router.doCommand(request);


        }
    }

}
