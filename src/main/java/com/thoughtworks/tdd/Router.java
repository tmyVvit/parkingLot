package com.thoughtworks.tdd;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class Router {
    private String currentPage;
    private ParkingView parkingView;
    private ParkingModel parkingModel;
    private Response response;

    private final String MAIN = "main";
    private final String PARK = "park";
    private final String UNPARK = "unPark";

    public Router(String _currentPage, ParkingModel _parkingModel) {
        currentPage = _currentPage;
        parkingView = new ParkingView();
        parkingModel = _parkingModel;
        response = new Response();
    }

    public Router(String _currentPage, ParkingView _parkingView, ParkingModel _parkingModel, Response _response) {
        currentPage = _currentPage;
        parkingView = _parkingView;
        parkingModel = _parkingModel;
        response = _response;
    }

    public String getCurrentPage(){
        return currentPage;
    }

    public void doCommand(Request request) {
        switch (currentPage) {
            case MAIN:
                doMainPageCommand(request);
                break;
            case PARK:
                doParkPageCommand(request);
                break;
            case UNPARK:
                doUnparkPageCommand(request);
                break;
            default:
                ;
        }
    }

    private void doUnparkPageCommand(Request request) {
        Ticket ticket = new Ticket(request.getCommand());
        try{
            Car car = parkingModel.unPark(ticket);
            unParkSuccessPrint(car);
        }catch (CannotFindTheCarException cannotFindTheCarException){
            unParkFailPrint();
        }finally {
            currentPage = MAIN;
        }
    }

    private void unParkFailPrint() {
        response.print(parkingView.unParkFail());
    }

    private void unParkSuccessPrint(Car car) {
        response.print(parkingView.unParkSuccess(car));
    }

    private void doParkPageCommand(Request request) {
        Car car = new Car(request.getCommand());
        Ticket ticket = parkingModel.park(car);
        parkSuccessPrint(ticket);

        currentPage = MAIN;
    }

    private void parkSuccessPrint(Ticket ticket) {
        response.print(parkingView.partSuccess(ticket));
    }

    private void doMainPageCommand(Request request) {
        String command = request.getCommand();
        switch (command) {
            case "1":
                currentPage = PARK;
                break;
            case "2":
                currentPage = UNPARK;
                break;
            default:
                doInputErr();
                break;
        }
    }

    private void doInputErr() {
        response.print(parkingView.printInputErr());
    }

    public void printPage() {
        switch (currentPage) {
            case MAIN:
                printMain();
                break;
            case PARK:
                printPark();
                break;
            case UNPARK:
                printUnPark();
                break;
        }
    }

    private void printUnPark() {
        response.print(parkingView.unPark());
    }

    private void printPark() {
        if (parkingModel.notFull()) {
            response.print(parkingView.parkWhenNotFullPrint());
        } else {
            response.print(parkingView.parkWhenFullPrint());
            currentPage = MAIN;
            printPage();
        }
    }

    private void printMain() {
        response.print(parkingView.showMainUI());
    }

}
