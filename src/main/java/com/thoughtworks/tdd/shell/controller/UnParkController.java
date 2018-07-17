package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.core.Car;
import com.thoughtworks.tdd.core.Ticket;
import com.thoughtworks.tdd.exception.CannotFindTheCarException;
import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;

public class UnParkController extends Controller {
    Response response;
    ParkingModel parkingModel;

    public UnParkController(Response _response, ParkingModel _parkingModel) {
        response = _response;
        parkingModel = _parkingModel;
    }

    @Override
    public void printPage() {
        response.print("请输入小票编号：\n");
    }

    @Override
    public String doCommand(Request request) {
        Ticket ticket = new Ticket(request.getCommand());
        try {
            Car car = parkingModel.unPark(ticket);
            response.print("车已取出，您的车牌号是:"+car.getCarid()+"\n");
        } catch (CannotFindTheCarException cannotFindTheCarException) {
            response.print("非法小票，无法取出车，请查证后再输\n");
        }
        return "forwards:base";
    }
}
