package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;

public class TryParkMAddLotController extends Controller {
    Response response;

    public TryParkMAddLotController(Response _response){
        response = _response;
    }

    @Override
    public String doCommand(Request request) {
        response.print("请输入你套添加的停车场信息（格式为：名称，车位）：\n");
        return "";
    }

    @Override
    public void printPage() {

    }
}
