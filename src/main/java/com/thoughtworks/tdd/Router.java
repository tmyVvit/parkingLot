package com.thoughtworks.tdd;


public class Router {
    private String currentPage;
    private ParkingController parkingController;

    private final String BASE = "base";
    private final String PARKSERVICE = "main";
    private final String PARKMANAGE = "parkManage";
    private final String PARK = "park";
    private final String UNPARK = "unPark";
    private final String CHECKLOTINFO = "checklotinfo";
    private final String ADDLOT = "addLot";
    private final String DELLOT = "delLot";

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
            case BASE:
                handlerBase(request);
                break;
            case PARKSERVICE:
                handlerMain(request);
                break;
            case PARKMANAGE:
                handlerManager(request);
                break;
            case PARK:
                handlerPark(request);
                break;
            case UNPARK:
                handlerUnPark(request);
                break;
            case CHECKLOTINFO:
                handlerCheckInfo(request);
                break;
            case ADDLOT:
                handlerAddLot(request);
                break;
            case DELLOT:
                handlerDelLot(request);
                break;
            default:
                ;
        }
    }

    private void handlerDelLot(Request request) {
        currentPage = parkingController.doDelLot(request);
    }

    private void handlerAddLot(Request request) {
        currentPage = parkingController.doAddLot(request);
    }

    private void handlerCheckInfo(Request request) {
        currentPage = parkingController.doCheckInfoCommand(request);
    }

    private void handlerManager(Request request) {
        currentPage = parkingController.doManageCommand(request);
    }

    private void handlerBase(Request request) {
        currentPage = parkingController.doBaseCommand(request);
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
            case BASE:
                parkingController.printBase();
                break;
            case PARKMANAGE:
                parkingController.printManage();
                break;
            case PARKSERVICE:
                parkingController.printMain();
                break;
            case PARK:
                currentPage = parkingController.printPark();
                break;
            case UNPARK:
                parkingController.printUnPark();
                break;
            case ADDLOT:
                parkingController.printAddInfo();
                break;
            case DELLOT:
                parkingController.printDelInfo();
                break;
        }
    }

}
