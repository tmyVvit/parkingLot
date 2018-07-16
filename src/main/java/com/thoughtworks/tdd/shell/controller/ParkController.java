package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.core.Car;
import com.thoughtworks.tdd.core.Ticket;
import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;
import com.thoughtworks.tdd.shell.controller.Controller;

public class ParkController extends Controller {
    private ParkingModel parkingModel;
    private Response response;

    public ParkController(Response _response, ParkingModel _parkingModel) {
        super();
        response = _response;
        parkingModel = _parkingModel;
    }

    @Override
    public void printPage() {

    }

    public String printPagep() {
        if(parkingModel.notFull()) {
            response.print("请输入车牌号:\n");
            return "park";
        }else {
            response.print("车已停满，请晚点再来\n");
            return "base";
        }
    }

    @Override
    public String doCommand(Request request) {
        Car car = new Car(request.getCommand());
        Ticket ticket = parkingModel.park(car);
        response.print("停车成功，您的小票是：\n"+ticket.getUUID()+"\n");

        return BASE;
    }
}
