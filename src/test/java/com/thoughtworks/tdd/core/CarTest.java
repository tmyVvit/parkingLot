package com.thoughtworks.tdd.core;

import com.thoughtworks.tdd.core.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    @Test
    public void should_return_car_id_when_call_getCarid() {
        // given
        Car car = new Car("1");
        String  expected_id = "1";

        // when
        String result = car.getCarid();

        // then
        assertEquals(expected_id, result);
    }

    @Test
    public void should_return_False_when_call_equals_two_cars_with_same_id(){
        Car car1 = new Car("1");
        Car car1_fake = new Car();

        boolean result = car1.equals(car1_fake);

        assertFalse(result);
    }
}
