package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    public void should_return_car_id_when_call_getCarid() {
        // given
        Car car = new Car(1);
        int expected_id = 1;

        // when
        int result = car.getCarid();

        // then
        assertEquals(expected_id, result);

    }
}
