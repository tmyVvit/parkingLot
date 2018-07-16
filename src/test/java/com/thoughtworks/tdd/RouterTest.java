package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RouterTest {
    @Test
    public void should_set_currenPage_park_when_call_doCommand_given_input_request_1_currentPage_main(){
    // given
        ParkingModel parkingModel = mock(ParkingModel.class);
        Request request = mock(Request.class);
        Router router = new Router("main", parkingModel);
        when(request.getCommand()).thenReturn("1");
    // when
        router.doCommand(request);
    // then
        assertEquals("park", router.getCurrentPage());
    }

    @Test
    public void should_set_currenPage_unpark_when_call_doCommand_given_input_request_2_currentPage_main(){
        // given
        ParkingModel parkingModel = mock(ParkingModel.class);
        Request request = mock(Request.class);
        Router router = new Router("main", parkingModel);
        when(request.getCommand()).thenReturn("2");
        // when
        router.doCommand(request);
        // then
        assertEquals("unPark", router.getCurrentPage());
    }

    @Test
    public void should_print_error_info_when_call_doCommand_given_input_request_command_invalid_currentPage_main(){
        // given
        ParkingModel parkingModel = mock(ParkingModel.class);
        ParkingView parkingView = mock(ParkingView.class);
        Response response = mock(Response.class);
        Request request = mock(Request.class);
        Router router = new Router("main",parkingView, parkingModel, response);
        when(request.getCommand()).thenReturn("as");
        when(parkingView.printInputErr()).thenReturn("非法指令，请查证后再输\n");
        // when
        router.doCommand(request);
        // then
        verify(response).print("非法指令，请查证后再输\n");
    }
}
