package com.thoughtworks.tdd;

import com.thoughtworks.tdd.core.ParkingBoy;
import com.thoughtworks.tdd.shell.*;

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
        ParkingBoy pb = new ParkingBoy();
        Router router = new Router(new ParkingModel(pb));
        router.init();
        while (true) {
            String command = main.getInput.get();
            request.setCommand(command);
            router.start(request);
        }
    }

}
