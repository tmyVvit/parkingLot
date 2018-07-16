package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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

    @Test
    public void should_print_park_success_when_call_doCommand_given_input_request_command_valid_currentPage_park(){
        // given
        ParkingModel parkingModel = mock(ParkingModel.class);
        ParkingView parkingView = mock(ParkingView.class);
        Response response = mock(Response.class);
        Request request = mock(Request.class);
        Router router = new Router("park",parkingView, parkingModel, response);
        when(request.getCommand()).thenReturn("as");
        when(parkingModel.park(any())).thenReturn(new Ticket("040e701f-8bad-41f4-94b4-23ec1463e8b4"));
        when(parkingView.partSuccess(any())).thenReturn("停车成功，您的小票是：\n040e701f-8bad-41f4-94b4-23ec1463e8b4\n");
        // when
        router.doCommand(request);
        // then
        verify(response).print("停车成功，您的小票是：\n040e701f-8bad-41f4-94b4-23ec1463e8b4\n");
    }

    @Test
    public void should_print_unpark_success_when_call_doCommand_given_input_request_command_valid_currentPage_unpark(){
        // given
        ParkingModel parkingModel = mock(ParkingModel.class);
        ParkingView parkingView = mock(ParkingView.class);
        Response response = mock(Response.class);
        Request request = mock(Request.class);
        Car car = mock(Car.class);
        Router router = new Router("unPark",parkingView, parkingModel, response);
        when(car.getCarid()).thenReturn("test-car");
        when(request.getCommand()).thenReturn("as");
        when(parkingModel.unPark(any())).thenReturn(car);
        when(parkingView.unParkSuccess(car)).thenReturn("车已取出，您的车牌号是:test-car\n");
        // when
        router.doCommand(request);
        // then
        verify(response).print("车已取出，您的车牌号是:test-car\n");
    }

    @Test
    public void should_print_unpark_fail_when_call_doCommand_parking_log_full(){
        // given
        ParkingModel parkingModel = mock(ParkingModel.class);
        ParkingView parkingView = mock(ParkingView.class);
        Response response = mock(Response.class);
        Request request = mock(Request.class);
        Car car = mock(Car.class);
        Router router = new Router("unPark",parkingView, parkingModel, response);
        when(car.getCarid()).thenReturn("test-car");
        when(request.getCommand()).thenReturn("as");
        when(parkingModel.unPark(any())).thenThrow(new CannotFindTheCarException());
        when(parkingView.unParkFail()).thenReturn("非法小票，无法取出车，请查证后再输\n");
        // when
        router.doCommand(request);
        // then
        verify(response).print("非法小票，无法取出车，请查证后再输\n");
    }

    @Test
    public void should_print_main_page_when_call_printPage_given_currentPage_main(){
        // given
        ParkingModel parkingModel = mock(ParkingModel.class);
        ParkingView parkingView = mock(ParkingView.class);
        Response response = mock(Response.class);
        Router router = new Router("main",parkingView, parkingModel, response);
        when(parkingView.showMainUI()).thenReturn("1.停车\n2.取车\n请输入您要进行的操作：\n");
        // when
        router.printPage();
        // then
        verify(response).print("1.停车\n2.取车\n请输入您要进行的操作：\n");
    }

    @Test
    public void should_print_park_page_when_call_printPage_given_currentPage_park_parking_lot_not_full(){
        // given
        ParkingModel parkingModel = mock(ParkingModel.class);
        ParkingView parkingView = mock(ParkingView.class);
        Response response = mock(Response.class);
        Router router = new Router("park",parkingView, parkingModel, response);
        when(parkingView.parkWhenNotFullPrint()).thenReturn("请输入车牌号:\n");
        when(parkingModel.notFull()).thenReturn(true);
        // when
        router.printPage();
        // then
        verify(response).print("请输入车牌号:\n");
    }

    @Test
    public void should_print_park_main_page_when_call_printPage_given_currentPage_park_parking_lot_is_full(){
        // given
        ParkingModel parkingModel = mock(ParkingModel.class);
        ParkingView parkingView = mock(ParkingView.class);
        Response response = mock(Response.class);
        Router router = new Router("park",parkingView, parkingModel, response);
        when(parkingView.parkWhenFullPrint()).thenReturn("车已停满，请晚点再来\n1.停车\n2.取车\n请输入您要进行的操作：\n");
        when(parkingModel.notFull()).thenReturn(false);
        // when
        router.printPage();
        // then
        verify(response).print("车已停满，请晚点再来\n1.停车\n2.取车\n请输入您要进行的操作：\n");
    }


}
