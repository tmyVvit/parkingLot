package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkingControllerTest {

    @Test
    public void should_return_currentPage_when_call_doMainCommand_given_different_request(){
    // given
        ParkingView parkingView = mock(ParkingView.class);
        ParkingModel parkingModel = mock(ParkingModel.class);
        Response response = mock(Response.class);
        ParkingController parkingController = new ParkingController(parkingModel, parkingView, response);
        Request request = mock(Request.class);
        when(request.getCommand()).thenReturn("1", "2", "asd");

        // when
        String result1 = parkingController.doMainCommand(request);
        String result2 = parkingController.doMainCommand(request);
        String result3 = parkingController.doMainCommand(request);
        // then
        assertEquals("park", result1);
        assertEquals("unPark", result2);
        assertEquals("main", result3);
    }
}
