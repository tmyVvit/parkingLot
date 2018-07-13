package com.thoughtworks.tdd;

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
        int command = sc.nextInt();

        return command;
    }

}
