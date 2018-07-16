package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;

public class ParkMAddLotController extends Controller {
    Response response;
    ParkingModel parkingModel;

    public ParkMAddLotController(Response _response, ParkingModel _parkingModel) {
        response = _response;
        parkingModel = _parkingModel;
    }

    @Override
    public void printPage() {
        response.print("请输入你套添加的停车场信息（格式为：名称，车位）：\n");
    }

    @Override
    public String doCommand(Request request) {
        String command = request.getCommand();
        try{
            String name = command.split(",")[0];
            int size = Integer.valueOf(command.split(",")[1]);
            parkingModel.addLot(size, name);
            response.print("停车场添加成功！\n");
        }catch (Exception ex){
            response.print("非法指令，请查证后再输\n");
        }

        return BASE;
    }
}
