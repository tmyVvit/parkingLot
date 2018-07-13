package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkingModelTest {
    @Test
    public void should_return_true_when_call_notFull_given_parkingLot_not_full(){
    // given
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingModel parkingModel = new ParkingModel(parkingBoy);
        when(parkingBoy.isAllFull()).thenReturn(false);
    // when
        boolean result = parkingModel.notFull();
    // then
        assertEquals(true, result);
    }
}
