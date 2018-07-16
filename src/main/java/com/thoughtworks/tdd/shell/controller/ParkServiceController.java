package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;

public class ParkServiceController extends Controller {
    private Response response;

    public ParkServiceController(Response _response) {
        response = _response;
    }

    @Override
    public String doCommand(Request request) {
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
                response.print("非法指令，请查证后再输\n");
                break;
        }
        return currentPage;
    }

    @Override
    public void printPage() {
        response.print("1.停车\n2.取车\n请输入您要进行的操作：\n");
    }
}
