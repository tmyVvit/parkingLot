package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;

public class TryParkController extends Controller {
    ParkingModel parkingModel;
    Response response;

    public TryParkController(Response _response, ParkingModel _parkingModel) {
        parkingModel = _parkingModel;
        response = _response;
    }

    @Override
    public void printPage() {
    }

    @Override
    public String doCommand(Request request) {
        String next = "";
        if(parkingModel.notFull()){
            response.print("请输入车牌号:\n");
        }else{
            response.print("车已停满，请晚点再来\n");
            next = "forwards:base";
        }
        return next;
    }
}
