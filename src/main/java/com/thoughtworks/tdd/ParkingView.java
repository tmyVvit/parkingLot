package com.thoughtworks.tdd;

public class ParkingView {

    public void start(){
        showMainUI();
    }

    public void showMainUI() {
        System.out.print("1.停车\n2.取车\n请输入您要进行的操作：");
    }

    public int getCommandNumber() {

        return 1;
    }

}
