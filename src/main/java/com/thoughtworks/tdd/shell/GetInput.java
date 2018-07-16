package com.thoughtworks.tdd.shell;

import java.util.Scanner;

public class GetInput {
    private Scanner sc = new Scanner(System.in);
    public String get(){
        String result = sc.nextLine();
//        sc.close();
        return result;
    }
    public void close() {
        sc.close();
    }
}
