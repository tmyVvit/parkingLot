package com.thoughtworks.tdd;

public class FizzBuzz {

    public String fizzBuzz(int number) {
        StringBuffer result=new StringBuffer();
        if(contain3(number)){
            result.append("Fizz");
        }else {
            if (number % 3 == 0) {
                result.append("Fizz");
            }
            if (number % 5 == 0) {
                result.append("Buzz");
            }
            if (number % 7 == 0) {
                result.append("Whizz");
            }
        }
        return result.toString().equals("")?String.valueOf(number):result.toString();
    }

    private boolean contain3(int number) {
        return String.valueOf(number).contains("3");

    }


}
