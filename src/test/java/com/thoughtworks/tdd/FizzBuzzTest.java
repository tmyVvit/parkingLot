package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
    @Test
    public void should_return_1_when_call_FizzBuzz_input_1(){
        //given
        int number = 1;
        FizzBuzz fizzBuzz = new FizzBuzz();

        //when
        String result = fizzBuzz.fizzBuzz(number);

        //then
        Assertions.assertEquals("1", result);

    }

    @Test
    public void should_return_Fizz_when_call_fizzBuzz_input_3(){
        int number=3;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        Assertions.assertEquals("Fizz",result);
    }

    @Test
    public void should_return_Fizz_when_call_fizzBuzz_input_6(){
        int number=6;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        Assertions.assertEquals("Fizz",result);
    }

    @Test
    public void should_return_Buzz_when_call_fizzBuzz_input_5(){
        int number=5;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        Assertions.assertEquals("Buzz",result);
    }

    @Test
    public void should_return_Buzz_when_call_fizzBuzz_input_10(){
        int number=10;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        Assertions.assertEquals("Buzz",result);
    }

    @Test
    public void should_return_Whizz_when_call_fizzBuzz_input_7(){
        int number=7;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        Assertions.assertEquals("Whizz",result);
    }

    @Test
    public void should_return_FizzBuzz_when_call_fizzBuzz_input_15(){
        int number=15;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        Assertions.assertEquals("FizzBuzz",result);
    }

    @Test
    public void should_return_FizzWhizz_when_call_fizzBuzz_input_21(){
        int number=21;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        Assertions.assertEquals("FizzWhizz",result);
    }

    @Test
    public void should_return_BuzzWhizz_when_call_fizzBuzz_input_35(){
        int number=35;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        Assertions.assertEquals("BuzzWhizz",result);
    }

    @Test
    public void should_return_FizzBuzzWhizz_when_call_fizzBuzz_input_105(){
        int number=105;
        FizzBuzz fizzBuzz=new FizzBuzz();

        String result=fizzBuzz.fizzBuzz(number);

        Assertions.assertEquals("FizzBuzzWhizz",result);
    }
}
