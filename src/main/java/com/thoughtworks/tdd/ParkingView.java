package com.thoughtworks.tdd;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingView {

    public void start(){
        showMainUI();
    }

    public void showMainUI() {
        System.out.print("1.停车\n2.取车\n请输入您要进行的操作：");
    }

    public int getCommandNumber() {
        Scanner sc = new Scanner(System.in);
        int command;
        try {
            command = sc.nextInt();
        }catch (InputMismatchException inputMismatchException){
            throw new InputNotNumberException();
        }
        if(command != 1 && command != 2)
            throw new InputNotNumberException();
        return command;
    }

}
