package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void should_return_true_when_call_equals_two_cars_with_same_id(){
        Car car1 = new Car(1);
        Car car1_fake = new Car(1);

        boolean result = car1.equals(car1_fake);

        assertTrue(result);
    }
}
