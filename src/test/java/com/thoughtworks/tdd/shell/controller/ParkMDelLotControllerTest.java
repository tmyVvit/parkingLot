package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.exception.ParkingLotNotEmptyException;
import com.thoughtworks.tdd.exception.ParkingLotNotExistsException;
import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ParkMDelLotControllerTest {
    @Test
    public void should_return_del_lot_page_when_call_printPage(){
    // given
        Response response = mock(Response.class);
        ParkingModel parkingModel = mock(ParkingModel.class);
        ParkMDelLotController parkMDelLotController = new ParkMDelLotController(response, parkingModel);
    // when
        parkMDelLotController.printPage();
    // then
        verify(response).print("请输入需要删除的被管理停车场ID:\n");
    }

    @Test
    public void should_print_different_page_when_call_doCommand_gifen_different_request(){
    // given
        Response response = mock(Response.class);
        ParkingModel parkingModel = mock(ParkingModel.class);
        ParkMDelLotController parkMDelLotController = new ParkMDelLotController(response, parkingModel);
        Request request = mock(Request.class);

        when(request.getCommand()).thenReturn("test");
        when(parkingModel.delLot("test")).thenReturn(true).thenThrow(new ParkingLotNotExistsException()).thenThrow(new ParkingLotNotEmptyException());
    // when
        parkMDelLotController.doCommand(request);
        parkMDelLotController.doCommand(request);
        parkMDelLotController.doCommand(request);

        // then
        verify(response).print("停车场删除成功！\n");
        verify(response).print("停车场添加失败，原因：此停车场不存在！\n");
        verify(response).print("停车场添加失败，原因：此停车场中，依然停有汽车，无法删除！\n");

    }
}
