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

        when(input.get()).thenReturn("1");

    // when
        try{
            int result = parkingView.getCommandNumber();
            assertEquals(1, result);
        }catch (InputNotValidException inputNotValidException){
            fail("should not throw the exception");
        }
    // then

    }

//    @Test
//    public void should_get_1_when_call_getCommandNumber_input_1_in_command_line(){
//    // given
//        GetInput input = mock(GetInput.class);
//        ParkingView parkingView = new ParkingView(input);
//        String input = "1";
//    // when
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        int result = parkingView.getCommandNumber();
//    // then
//        assertEquals(1, result);
//    }
//
//    @Test
//    public void should_throw_exception_when_call_getCommandNumber_input_is_not_1_2(){
//    // given
//        ParkingView parkingView = new ParkingView();
//        String input = "abc";
//    // when
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//    // then
//        try {
//            parkingView.getCommandNumber();
//            fail("should catch the exception");
//        }catch(InputNotValidException inputNotValidException){
//        }
//    }

//    @Test
//    public void should_return_err_UI_when_call_start_input_invalid(){
//    // given
////        ParkingView parkingView = new ParkingView();
////        String input = "ad";
////    // when
////        System.setIn(new ByteArrayInputStream(input.getBytes()));
////    // then
////        parkingView.start();
////        assertEquals("1.停车\n2.取车\n请输入您要进行的操作：非法指令，请查证后再输\n1.停车\n2.取车\n请输入您要进行的操作：", new String(outContent.toByteArray()));
//
//        ParkingView parkingView = mock(ParkingView.class);
//        when(parkingView.getCommandNumber()).thenThrow(new InputNotValidException()).thenReturn(1);
//        //when(parkingView.showMainUI()).thenReturn(null);
//
//        parkingView.start();
//        verify(parkingView).printInputErr();
//    }
}
