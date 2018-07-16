package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.exception.ParkingLotNotEmptyException;
import com.thoughtworks.tdd.exception.ParkingLotNotExistsException;
import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;

public class ParkMDelLotController extends Controller {
    Response response;
    ParkingModel parkingModel;

    public ParkMDelLotController(Response _response, ParkingModel _parkingModel) {
        response = _response;
        parkingModel = _parkingModel;
    }

    @Override
    public void printPage() {
        response.print("请输入需要删除的被管理停车场ID:\n");
    }

    @Override
    public String doCommand(Request request) {
        String id = request.getCommand();
        try{
            parkingModel.delLot(id);
            response.print("停车场删除成功！\n");
        }catch (ParkingLotNotExistsException parkingLotNotExistsException){
            response.print("停车场添加失败，原因：此停车场不存在！\n");
        }catch (ParkingLotNotEmptyException parkingLotNotEmptyException){
            response.print("停车场添加失败，原因：此停车场中，依然停有汽车，无法删除！\n");
        }

        return BASE;
    }
}
