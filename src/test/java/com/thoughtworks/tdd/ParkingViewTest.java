package com.thoughtworks.tdd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ParkingViewTest {
    @Test
    public void should_print_main_page_when_call_showMainUI(){
    // given
        ParkingView parkingView = new ParkingView();
    // when
        String result = parkingView.showMainUI();
    // then
        assertEquals("1.停车\n2.取车\n请输入您要进行的操作：\n", result);
    }

    @Test
    public void should_print_error_when_call_printInputErr(){
        // given
        ParkingView parkingView = new ParkingView();
        // when
        String result = parkingView.printInputErr();
        // then
        assertEquals("非法指令，请查证后再输\n", result);;
    }

    @Test
    public void should_print_parking_lot_full_when_call_parkWhenFullPrint(){
    // given
        ParkingView parkingView = new ParkingView();
    // when
        String result = parkingView.parkWhenFullPrint();
    // then
        assertEquals("车已停满，请晚点再来\n", result);
    }

    @Test
    public void should_print_input_car_id_when_call_parkWhenNotFullPrint(){
        // given
        ParkingView parkingView = new ParkingView();
        // when
        String result = parkingView.parkWhenNotFullPrint();
        // then
        assertEquals("请输入车牌号:\n", result);
    }


    @Test
    public void should_print_park_successful_and_ticket_id_when_call_parkSuccess(){
        // given
        ParkingView parkingView = new ParkingView();
        Ticket ticket = mock(Ticket.class);
        when(ticket.getUUID()).thenReturn("040e701f-8bad-41f4-94b4-23ec1463e8b4");
        // when
        String result = parkingView.partSuccess(ticket);
        // then
        assertEquals("停车成功，您的小票是：\n040e701f-8bad-41f4-94b4-23ec1463e8b4\n", result);
    }

    @Test
    public void should_print_unPark_info_when_call_unpark(){
    // given
        ParkingView parkingView = new ParkingView();
    // when
        String result = parkingView.unPark();
    // then
        assertEquals("请输入小票编号：", result );
    }
    @Test
    public void should_print_ticket_id_when_call_unParkSuccess(){
    // given
        ParkingView parkingView = new ParkingView();
        Car car = mock(Car.class);
        when(car.getCarid()).thenReturn("test-car");
    // when
        String result = parkingView.unParkSuccess(car);
    // then
        assertEquals("车已取出，您的车牌号是:test-car\n", result);
    }
    @Test
    public void should_print_unpark_failed_when_call_unParkFail(){
    // given

        ParkingView parkingView = new ParkingView();
    // when
        String result = parkingView.unParkFail();
    // then
        assertEquals("非法小票，无法取出车，请查证后再输\n", result);
    }
}
