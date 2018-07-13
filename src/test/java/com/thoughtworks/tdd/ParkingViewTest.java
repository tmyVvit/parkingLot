package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ParkingViewTest {

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

}
