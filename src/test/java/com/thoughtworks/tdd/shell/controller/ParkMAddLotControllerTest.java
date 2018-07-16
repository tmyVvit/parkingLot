package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ParkMAddLotControllerTest {
    @Test
    public void should_print_add_lot_page_when_call_printPage(){
    // given
        Response response = mock(Response.class);
        ParkingModel parkingModel = mock(ParkingModel.class);

        ParkMAddLotController parkMAddLotController = new ParkMAddLotController(response, parkingModel);

    // when
        parkMAddLotController.printPage();
    // then
        verify(response).print("请输入你套添加的停车场信息（格式为：名称，车位）：\n");;
    }

    @Test
    public void should_print_add_sucess_when_call_doCommand_given_valid_request(){
    // given
        Response response = mock(Response.class);
        ParkingModel parkingModel = mock(ParkingModel.class);
        Request request = mock(Request.class);
        ParkMAddLotController parkMAddLotController = new ParkMAddLotController(response, parkingModel); ;

        when(request.getCommand()).thenReturn("test,12");
    // when
        parkMAddLotController.doCommand(request);
    // then
        verify(response).print("停车场添加成功！\n");;
    }

    @Test
    public void should_throw_exception_when_call_doCommand_given_invalid_request(){
        // given
        Response response = mock(Response.class);
        ParkingModel parkingModel = mock(ParkingModel.class);
        Request request = mock(Request.class);
        ParkMAddLotController parkMAddLotController = new ParkMAddLotController(response, parkingModel); ;

        when(request.getCommand()).thenReturn("test,df");
        // when
        parkMAddLotController.doCommand(request);
        // then
        verify(response).print("非法指令，请查证后再输\n");;
    }


}
