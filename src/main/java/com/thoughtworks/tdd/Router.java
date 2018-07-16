package com.thoughtworks.tdd;


public class Router {
    private String currentPage;
    private ParkingController parkingController;

    private final String MAIN = "main";
    private final String PARK = "park";
    private final String UNPARK = "unPark";

    public Router(String _currentPage, ParkingModel _parkingModel) {
        currentPage = _currentPage;
        parkingController = new ParkingController(_parkingModel, new ParkingView(), new Response());
    }

    public Router(String _currentPage, ParkingView _parkingView, ParkingModel _parkingModel, Response _response) {
        currentPage = _currentPage;
        parkingController = new ParkingController(_parkingModel, _parkingView, _response);
    }

    public String getCurrentPage(){
        return currentPage;
    }

    public void doCommand(Request request) {
        switch (currentPage) {
            case MAIN:
                handlerMain(request);
                break;
            case PARK:
                handlerPark(request);
                break;
            case UNPARK:
                handlerUnPark(request);
                break;
            default:
                ;
        }
    }

    private void handlerUnPark(Request request) {
        currentPage = parkingController.doUnParkCommand(request);
    }

    private void handlerMain(Request request) {
        currentPage = parkingController.doMainCommand(request);
    }
    private void handlerPark(Request request) {
        currentPage = parkingController.doParkCommand(request);
    }


    public void printPage() {
        switch (currentPage) {
            case MAIN:
                parkingController.printMain();
                break;
            case PARK:
                currentPage = parkingController.printPark();
                break;
            case UNPARK:
                parkingController.printUnPark();
                break;
        }
    }

}
