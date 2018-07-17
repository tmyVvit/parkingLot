package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;

public class ErrController extends Controller{

    Response response;
    public ErrController(Response _response){ response = _response;}

    @Override
    public String doCommand(Request request) {
        printPage();
        return null;
    }

    @Override
    public void printPage() {
        response.print("非法指令，请查证后再输\n");
    }
}
