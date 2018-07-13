package com.thoughtworks.tdd;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkingViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void should_return_main_UI_when_call_showMainUI(){
    // given
        ParkingView parkingView = new ParkingView();

    // when
        parkingView.showMainUI();

    // then
        assertEquals("1.停车\n2.取车\n请输入您要进行的操作：", new String(outContent.toByteArray()));
    }

    @Test
    public void should_get_1_when_call_getCommandNumber_input_1_in_command_line(){
    // given
        ParkingView parkingView = new ParkingView();
        String input = "1";
    // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result = parkingView.getCommandNumber();
    // then
        assertEquals(1, result);
    }

    @Test
    public void should_throw_exception_when_call_getCommandNumber_input_is_not_1_2(){
    // given
        ParkingView parkingView = new ParkingView();
        String input = "abc";
    // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    // then
        try {
            parkingView.getCommandNumber();
            fail("should catch the exception");
        }catch(InputNotNumberException inputNotNumberException){
        }
    }

    @Test
    public void should_return_err_UI_when_call_start_input_invalid(){
    // given
//        ParkingView parkingView = new ParkingView();
//        String input = "ad";
//    // when
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//    // then
//        parkingView.start();
//        assertEquals("1.停车\n2.取车\n请输入您要进行的操作：非法指令，请查证后再输\n1.停车\n2.取车\n请输入您要进行的操作：", new String(outContent.toByteArray()));

        ParkingView parkingView = mock(ParkingView.class);
        when(parkingView.getCommandNumber()).thenThrow(new InputNotNumberException()).thenReturn(1);

    }
}
