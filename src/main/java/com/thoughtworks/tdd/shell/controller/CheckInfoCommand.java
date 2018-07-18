package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.core.ParkingLot;
import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;

import java.util.List;

public class CheckInfoCommand extends Controller{
    Response response;
    ParkingModel parkingModel;

    public CheckInfoCommand(Response _response,ParkingModel _parkingModel){
        response = _response;
        parkingModel = _parkingModel;
    }

    @Override
    public String doCommand(Request request) {
        StringBuilder lotsInfo = new StringBuilder("|停车场ID|名称|车位|已停车辆|剩余车位|\n" +
                "======================================\n");
//        int lotsCount = parkingModel.parkingLotsCount();
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
        return "forwards:base";
    }

    @Override
    public void printPage() {

    }
}
