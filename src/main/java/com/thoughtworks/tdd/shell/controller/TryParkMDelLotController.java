package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;
import com.thoughtworks.tdd.shell.controller.Controller;

public class TryParkMDelLotController extends Controller {
    Response response;
    public TryParkMDelLotController(Response _response) {
        super();
        response = _response;
    }

    @Override
    public void printPage() {

    }

    @Override
    public String doCommand(Request request) {
        response.print("请输入需要删除的被管理停车场ID:\n");
        return "";
    }
}
