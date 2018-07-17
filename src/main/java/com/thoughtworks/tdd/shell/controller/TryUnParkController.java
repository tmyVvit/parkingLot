package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;

public class TryUnParkController extends Controller {
    Response response;

    public TryUnParkController(Response _response) {
        response = _response;
    }

    @Override
    public String doCommand(Request request) {
        response.print("请输入小票编号：\n");
        return "";
    }

    @Override
    public void printPage() {
    }
}
