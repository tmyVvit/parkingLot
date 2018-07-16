package com.thoughtworks.tdd;

import java.util.Map;

public class ParkingController {
    private ParkingModel parkingModel;
    private ParkingView parkingView;
    private Response response;

    private final String MAIN = "main";
    private final String PARK = "park";
    private final String UNPARK = "unPark";

    public ParkingController(ParkingModel _parkingModel, ParkingView _parkingView, Response _response) {
        parkingModel = _parkingModel;
        parkingView = _parkingView;
        response = _response;
    }


    public String doMainCommand(Request request) {
        String command = request.getCommand();
        String currentPage = MAIN;
        switch (command) {
            case "1":
                currentPage = PARK;
                break;
            case "2":
                currentPage = UNPARK;
                break;
            default:
                response.print(parkingView.printInputErr());
                break;
        }
        return currentPage;
    }

    public String doParkCommand(Request request) {

        Car car = new Car(request.getCommand());
        Ticket ticket = parkingModel.park(car);
        response.print(parkingView.partSuccess(ticket));

        return MAIN;
    }

    public String doUnParkCommand(Request request) {
        Ticket ticket = new Ticket(request.getCommand());
        try {
            Car car = parkingModel.unPark(ticket);
            response.print(parkingView.unParkSuccess(car));
        } catch (CannotFindTheCarException cannotFindTheCarException) {
            response.print(parkingView.unParkFail());
        }
        return MAIN;
    }

    public void printMain() {
        response.print(parkingView.showMainUI());
    }

    public String printPark() {
        String currentPage = PARK;
        if (parkingModel.notFull()) {
            response.print(parkingView.parkWhenNotFullPrint());
        } else {
            response.print(parkingView.parkWhenFullPrint());
            printMain();
            currentPage = MAIN;
        }
        return currentPage;
    }

    public void printUnPark() {
        response.print(parkingView.unPark());
    }
}
