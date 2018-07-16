package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.core.Car;
import com.thoughtworks.tdd.core.Ticket;
import com.thoughtworks.tdd.exception.CannotFindTheCarException;
import com.thoughtworks.tdd.shell.ParkingModel;
import com.thoughtworks.tdd.shell.Request;
import com.thoughtworks.tdd.shell.Response;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UnParkControllerTest {
    @Test
    public void should_print_unpark_page_when_call_printPage(){
    // given
        ParkingModel parkingModel = mock(ParkingModel.class);
        Response response = mock(Response.class);
        UnParkController unParkController = new UnParkController(response, parkingModel);
    // when
        unParkController.printPage();
    // then
        verify(response).print("请输入小票编号：\n");
    }

    @Test
    public void should_print_different_page_when_call_doCommand_given_different_request(){
    // given
        ParkingModel parkingModel = mock(ParkingModel.class);
        Response response = mock(Response.class);
        Request request = mock(Request.class);
        UnParkController unParkController = new UnParkController(response, parkingModel);
        Car car = mock(Car.class);
        when(car.getCarid()).thenReturn("test-car");
        when(request.getCommand()).thenReturn("a315cea5-3ee0-4bf3-b505-ebce680fb11d");
        when(parkingModel.unPark(new Ticket("a315cea5-3ee0-4bf3-b505-ebce680fb11d"))).thenReturn(car).thenThrow(new CannotFindTheCarException());
    // when
        unParkController.doCommand(request);
        unParkController.doCommand(request);
        // then
        verify(response).print("车已取出，您的车牌号是:test-car\n");
        verify(response).print("非法小票，无法取出车，请查证后再输\n");
    }
}
