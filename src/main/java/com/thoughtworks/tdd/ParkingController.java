package com.thoughtworks.tdd;

import java.util.List;

public class ParkingController {
    private ParkingModel parkingModel;
    private ParkingView parkingView;
    private Response response;

    private final String BASE = "base";
    private final String PARKSERVICE = "main";
    private final String PARKMANAGE = "parkManage";
    private final String PARK = "park";
    private final String UNPARK = "unPark";
    private final String CHECKLOTINFO = "checkLotinfo";
    private final String ADDLOT = "addLot";
    private final String DELLOT = "delLot";

    public ParkingController(ParkingModel _parkingModel, ParkingView _parkingView, Response _response) {
        parkingModel = _parkingModel;
        parkingView = _parkingView;
        response = _response;
    }

    public String doBaseCommand(Request request) {
        String command = request.getCommand();
        String currentPage = BASE;
        switch (command) {
            case "1":
                currentPage = PARKSERVICE;
                break;
            case "2":
                currentPage = PARKMANAGE;
                break;
            default:
                printInputErr();
                break;
        }
        return currentPage;
    }


    public String doMainCommand(Request request) {
        String command = request.getCommand();
        String currentPage = BASE;
        switch (command) {
            case "1":
                currentPage = PARK;
                break;
            case "2":
                currentPage = UNPARK;
                break;
            default:
                printInputErr();
                break;
        }
        return currentPage;
    }

    public String doManageCommand(Request request) {
        String command = request.getCommand();
        String currentPage = BASE;
        switch (command) {
            case "1":
                doCheckInfoCommand(request);
//                currentPage = CHECKLOTINFO;
                break;
            case "2":
                currentPage = ADDLOT;
                break;
            case "3":
                currentPage = DELLOT;
                break;
            default:
                printInputErr();
                break;
        }
        return currentPage;
    }

    private void printInputErr() {
        response.print(parkingView.printInputErr());
    }

    public String doParkCommand(Request request) {

        Car car = new Car(request.getCommand());
        Ticket ticket = parkingModel.park(car);
        response.print(parkingView.partSuccess(ticket));

        return BASE;
    }

    public String doUnParkCommand(Request request) {
        Ticket ticket = new Ticket(request.getCommand());
        try {
            Car car = parkingModel.unPark(ticket);
            response.print(parkingView.unParkSuccess(car));
        } catch (CannotFindTheCarException cannotFindTheCarException) {
            response.print(parkingView.unParkFail());
        }
        return BASE;
    }

    public String doCheckInfoCommand(Request request) {
        StringBuilder lotsInfo = new StringBuilder("|停车场ID|名称|车位|已停车辆|剩余车位|\n" +
                "======================================\n");
        int lotsCount = parkingModel.parkingLotsCount();
        int spaceCount = 0, parkedCarCount = 0, lotsLeft = 0;
        List<ParkingLot> parkingLotList = parkingModel.getParkinglots();
        for(ParkingLot pl : parkingLotList){
            int parkCar = pl.stopedCarsCounts();
            int lotLeft = pl.lotsLeft();
            String tmp = String.format("|%s|%s|%d(个)|%d(辆)|%d(个)|\n",pl.getId(),pl.getName(), pl.getSize(), parkCar, lotLeft);
            lotsInfo.append(tmp);
            spaceCount += pl.getSize();
            parkedCarCount += parkCar;
            lotsLeft += lotLeft;
        }

        lotsInfo.append(String.format("\n总车位：%d(个)\n" +
                "停车总量：%d（辆）\n" +
                "总剩余车位：%d（个）\n", spaceCount, parkedCarCount, lotsLeft));

        response.print(lotsInfo.toString());
//        printBase();
        return BASE;
    }

    public String doAddLot(Request request) {
        String command = request.getCommand();
        try{
            String name = command.split(",")[0];
            int size = Integer.valueOf(command.split(",")[1]);
            parkingModel.addLot(size, name);
            response.print(parkingView.showAddSuccess());
        }catch (Exception ex){
            response.print(parkingView.printInputErr());
        }

        return BASE;
    }

    public String doDelLot(Request request) {
        String id = request.getCommand();
        try{
            parkingModel.delLot(id);
            response.print(parkingView.delLotSuccess());
        }catch (ParkingLotNotExists parkingLotNotExists){
            response.print(parkingView.delFailNotExist());
        }catch (ParkingLotNotEmptyException parkingLotNotEmptyException){
            response.print(parkingView.delFailNotEmpty());
        }

        return BASE;
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
            currentPage = PARKSERVICE;
        }
        return currentPage;
    }

    public void printUnPark() {
        response.print(parkingView.unPark());
    }


    public void printBase() {
        response.print(parkingView.showBasePage());
    }


    public void printManage() {
        response.print(parkingView.showManagePage());
    }


    public void printAddInfo() {
        response.print(parkingView.showAddLot());
    }

    public void printDelInfo() {
        response.print(parkingView.showDelLot());
    }


}
