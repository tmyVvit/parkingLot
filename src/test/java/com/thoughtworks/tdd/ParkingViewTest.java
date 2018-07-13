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

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    @BeforeEach
    public void init(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void should_get_PARKCOMMAND_when_call_getCommandNumber_given_input_1(){
    // given
        GetInput input = mock(GetInput.class);
        ParkingView parkingView = new ParkingView(input);
        // when
        when(input.get()).thenReturn("1");
        // then
        try{
            int result = parkingView.getCommandNumber();
            assertEquals(1, result);
        }catch (InputNotValidException inputNotValidException){
            fail("should not throw the exception");
        }
    }

    @Test
    public void should_get_UNPARKCOMMAND_when_call_getCommandNumber_given_input_2(){
        // given
        GetInput input = mock(GetInput.class);
        ParkingView parkingView = new ParkingView(input);
        // when
        when(input.get()).thenReturn("2");
        // then
        try{
            int result = parkingView.getCommandNumber();
            assertEquals(2, result);
        }catch (InputNotValidException inputNotValidException){
            fail("should not throw the exception");
        }
    }

    @Test
    public void should_throw_exception_when_call_getCommandNumber_given_input_invalid(){
        // given
        GetInput input = mock(GetInput.class);
        ParkingView parkingView = new ParkingView(input);
        when(input.get()).thenReturn("abc");
        // when
        // then
        try{
            parkingView.getCommandNumber();
            fail("should not throw the exception");
        }catch (InputNotValidException inputNotValidException){
        }
    }

    @Test
    public void should_get_throw_exception_when_call_start_given_invalid_input(){
    // given
        GetInput input = mock(GetInput.class);
        ParkingView parkingView = new ParkingView(input);
        when(input.get()).thenReturn("abc");
    // when
        // then

        try {
            parkingView.start();
        }catch (InputNotValidException inputNotValidException){
        }
    }
    @Test
    public void should_print_parking_lot_full_when_call_parkWhenFullPrint(){
    // given
        ParkingView parkingView = new ParkingView(mock(GetInput.class));
    // when
        parkingView.parkWhenFullPrint();
    // then
        assertEquals("车已停满，请晚点再来\n", outContent.toString());
    }
    @Test
    public void should_print_input_car_id_when_call_parkWhenNotFullPrint(){
        // given
        ParkingView parkingView = new ParkingView(mock(GetInput.class));
        // when
        parkingView.parkWhenNotFullPrint();
        // then
        assertEquals("请输入车牌号:", outContent.toString());
    }
    @Test
    public void should_print_park_successful_and_ticket_id_when_call_parkSuccess(){
        // given
        ParkingView parkingView = new ParkingView(mock(GetInput.class));
        Ticket ticket = mock(Ticket.class);
        when(ticket.getUUID()).thenReturn("test-uuid");
        // when
        parkingView.partSuccess(ticket);
        // then
        assertEquals("停车成功，您的小票是：\ntest-uuid", outContent.toString());
    }

    @Test
    public void should_print_input_ticket_id_when_call_unpark(){
    // given
        GetInput input = mock(GetInput.class);
        ParkingView parkingView = new ParkingView(input);
        when(input.get()).thenReturn("test-uuid");
    // when
        parkingView.unPark();
    // then
        assertEquals("请输入小票编号：", outContent.toString());
    }
    @Test
    public void should_print_ticket_id_when_call_unParkSuccess(){
    // given
        GetInput input = mock(GetInput.class);
        ParkingView parkingView = new ParkingView(input);
        Car car = mock(Car.class);
        when(car.getCarid()).thenReturn("test-car");
    // when
        parkingView.unParkSuccess(car);
    // then
        assertEquals("车已取出，您的车牌号是:test-car", outContent.toString());
    }
    @Test
    public void should_print_unpark_failed_when_call_unParkFail(){
    // given
        GetInput input = mock(GetInput.class);
        ParkingView parkingView = new ParkingView(input);
    // when
        parkingView.unParkFail();
    // then
        assertEquals("非法小票，无法取出车，请查证后再输\n", outContent.toString());
    }
}
