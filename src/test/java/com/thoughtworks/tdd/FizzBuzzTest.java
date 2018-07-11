package com.thoughtworks.tdd;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {
    @Test
    public void should_return_1_when_call_FizzBuzz_input_1(){
        //given
        int number = 1;
        FizzBuzz fizzBuzz = new FizzBuzz();

        //when
        String result = fizzBuzz.fizzBuzz(number);

        //then
        assertEquals("1", result);
//        assertThat(result,is("1"));
//        assertAll("input_number_return_number",
//                ()->assertEquals("1", fizzBuzz.fizzBuzz(1)),
//                ()->assertEquals("2", fizzBuzz.fizzBuzz(2)));


    }

    @Test
    public void should_return_Fizz_when_call_fizzBuzz_input_3(){
        int number=3;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        assertEquals("Fizz",result);
    }

    @Test
    public void should_return_Fizz_when_call_fizzBuzz_input_6(){
        int number=6;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        assertEquals("Fizz",result);
    }

    @Test
    public void should_return_Buzz_when_call_fizzBuzz_input_5(){
        int number=5;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        assertEquals("Buzz",result);
    }

    @Test
    public void should_return_Buzz_when_call_fizzBuzz_input_10(){
        int number=10;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        assertEquals("Buzz",result);
    }

    @Test
    public void should_return_Whizz_when_call_fizzBuzz_input_7(){
        int number=7;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        assertEquals("Whizz",result);
    }

    @Test
    public void should_return_FizzBuzz_when_call_fizzBuzz_input_15(){
        int number=15;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        assertEquals("FizzBuzz",result);
    }

    @Test
    public void should_return_FizzWhizz_when_call_fizzBuzz_input_21(){
        int number=21;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        assertEquals("FizzWhizz",result);
    }

    @Test
    public void should_return_BuzzWhizz_when_call_fizzBuzz_input_35(){
        int number=35;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        assertEquals("Fizz",result);
    }

    @Test
    public void should_return_FizzBuzzWhizz_when_call_fizzBuzz_input_105(){
        int number=105;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        assertEquals("FizzBuzzWhizz",result);
    }

    @Test
    public void should_return_Fizz_when_call_fizzBuzz_input_13(){
        int number=13;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        assertEquals("Fizz",result);
    }

    @Test
    public void should_return_Fizz_when_call_fizzBuzz_input_37(){
        int number=37;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        assertEquals("Fizz",result);
    }

}
