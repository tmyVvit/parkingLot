package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ParkServiceControllerTest {
    @Test
    public void should_print_page_when_call_printPage(){
    // given
        Response response = mock(Response.class);
        ParkServiceController parkServiceController = new ParkServiceController(response);
    // when
        parkServiceController.printPage();
    // then
        verify(response).print("1.停车\n2.取车\n请输入您要进行的操作：\n");
    }

    @Test
    public void should_return_different_currentPage_print_when_call_coCommand_given_different_request(){
    // given
        Response response = mock(Response.class);
        ParkServiceController parkServiceController = new ParkServiceController(response);
        Request request = mock(Request.class);

        when(request.getCommand()).thenReturn("1", "2","qw");
    // when
        String result1 = parkServiceController.doCommand(request);
        String result2 = parkServiceController.doCommand(request);
        String result3 = parkServiceController.doCommand(request);
        // then
        assertEquals("park", result1);
        assertEquals("unPark", result2);
        assertEquals("base", result3);

        verify(response).print("非法指令，请查证后再输\n");
    }
}
