package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;

public class BaseController extends Controller {
    Response response;

    public BaseController(Response _response) {
        response = _response;
    }
    @Override
    public String doCommand(Request request) {
        printPage();
//        String command = request.getCommand();
//        String currentPage = BASE;
//        switch (command) {
//            case "1":
//                currentPage = PARKSERVICE;
//                break;
//            case "2":
//                currentPage = PARKMANAGE;
//                break;
//            default:
//                response.print("非法指令，请查证后再输\n");
//                break;
//        }
//        return currentPage;
        return "";
    }

    public void printPage() {
        response.print("1.停车服务\n" +
                "2.停车场管理\n" +
                "请输入您要进入的页面：\n");
    }
}
