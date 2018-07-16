package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.core.Ticket;
import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ParkControllerTest {
    @Test
    public void should_print_different_page_when_call_printPagep(){
    // given
        Request request = mock(Request.class);
        ParkingModel parkingModel = mock(ParkingModel.class);
        Response response = mock(Response.class);
        ParkController parkController = new ParkController(response, parkingModel);
        when(parkingModel.notFull()).thenReturn(true, false);

    // when
        String result1 = parkController.printPagep();
        String result2 = parkController.printPagep();
    // then
        verify(response).print("请输入车牌号:\n");
        verify(response).print("车已停满，请晚点再来\n");
        assertEquals("park", result1);
        assertEquals("base", result2);
    }

    @Test
    public void should_print_park_success_when_call_doCommand_given_request(){
    // given
        Request request = mock(Request.class);
        ParkingModel parkingModel = mock(ParkingModel.class);
        Response response = mock(Response.class);
        ParkController parkController = new ParkController(response, parkingModel);

        Ticket ticket = mock(Ticket.class);
        when(ticket.getUUID()).thenReturn("test-uuid");
        when(request.getCommand()).thenReturn("car-id");
        when(parkingModel.park(any())).thenReturn(ticket);
        // when
        parkController.doCommand(request);
    // then
        verify(response).print("停车成功，您的小票是：\ntest-uuid\n");
    }

    @Test
    public void should_get_nothing_when_call_printPage(){
    // given
        Request request = mock(Request.class);
        ParkingModel parkingModel = mock(ParkingModel.class);
        Response response = mock(Response.class);
        ParkController parkController = new ParkController(response, parkingModel);;
    // when
        parkController.printPage();
    // then
        ;
    }
}
