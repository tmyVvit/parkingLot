package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.core.ParkingLot;
import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ParkManageControllerTest {
    @Test
    public void should_return_different_currentPage_when_call_doCommand_given_input_234(){
    // given
        Response response = mock(Response.class);
        ParkingModel parkingModel = mock(ParkingModel.class);
        Request request = mock(Request.class);
        ParkManageController parkManageController = new ParkManageController(response, parkingModel);
        when(request.getCommand()).thenReturn("2", "3", "4");

    // when
        String result1 = parkManageController.doCommand(request);
        String result2 = parkManageController.doCommand(request);
        String result3 = parkManageController.doCommand(request);
        // then
        assertEquals("addLot", result1);
        assertEquals("delLot", result2);
        assertEquals("base", result3);
    }

    @Test
    public void should_print_parking_lot_info_when_call_doComman_given_input_1(){
    // given
        Response response = mock(Response.class);
        ParkingModel parkingModel = mock(ParkingModel.class);
        Request request = mock(Request.class);
        ParkManageController parkManageController = new ParkManageController(response, parkingModel);
        when(request.getCommand()).thenReturn("1");
        List<ParkingLot> pls = new ArrayList<>();
        pls.add(new ParkingLot(1, "test", "001"));
        when(parkingModel.getParkinglots()).thenReturn(pls);
    // when
        parkManageController.doCommand(request);
    // then
        verify(response).print("|停车场ID|名称|车位|已停车辆|剩余车位|\n" +
                "======================================\n" +
                "|001|test|1(个)|0(辆)|1(个)|\n" +
                "\n总车位：1(个)\n" +
                "停车总量：0（辆）\n" +
                "总剩余车位：1（个）\n");
    }
}
