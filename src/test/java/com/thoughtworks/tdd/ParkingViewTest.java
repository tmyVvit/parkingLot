package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingViewTest {
    @Test
    public void should_return_main_UI_when_call_showMainUI(){
    // given
        ParkingView parkingView = new ParkingView();
        PrintStream oldOut = System.out;

        // Create a ByteArrayOutputStream so that we can get the output
        // from the call to print
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // Change System.out to point out to our stream
        System.setOut(new PrintStream(baos));

    // when
        parkingView.showMainUI();
        System.setOut(oldOut);
        String output = new String(baos.toByteArray());

    // then
        assertEquals("1.停车\n2.取车\n请输入您要进行的操作：", output);
    }
}
