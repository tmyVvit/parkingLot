package com.thoughtworks.tdd;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingView {

    public void start(){
        showMainUI();
        int commandNumber = 0;
        try{
            commandNumber = getCommandNumber();
        }catch (InputNotNumberException inputNotNumberException){
            System.out.print("非法指令，请查证后再输\n");
            start();
        }
        doNext(commandNumber);
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
    public void doNext(int commandNumber) {

    }

}
