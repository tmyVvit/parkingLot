package com.thoughtworks.tdd;

import java.util.Scanner;

public class GetInput {
    public String get(){
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
//        sc.close();
        return result;
    }
}
