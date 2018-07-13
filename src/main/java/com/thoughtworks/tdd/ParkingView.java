package com.thoughtworks.tdd;

import java.util.UUID;

public class ParkingView {
    private GetInput getInput;
    //private
    private final String PARK = "1";
    private final String UNPARK = "2";
    private final int PARKCOMMAND = 1;
    private final int UNPARKCOMMAND = 2;


    public ParkingView(GetInput _getInput) {
        getInput = _getInput;
    }

    public int start(){
        showMainUI();
        try{
            return getCommandNumber();
        }catch (InputNotValidException inputNotValidException){
            printInputErr();
            throw inputNotValidException;
        }
    }

    public void showMainUI() {
        System.out.print("1.停车\n2.取车\n请输入您要进行的操作：");
    }

    public int getCommandNumber() {
        String input = getInput.get();
        if(input.equals(PARK)){
            return PARKCOMMAND;
        } else if(input.equals(UNPARK)){
            return UNPARKCOMMAND;
        } else {
            throw new InputNotValidException();
        }
    }

    public void printInputErr() {
        System.out.print("非法指令，请查证后再输\n");
    }

    public void parkWhenFullPrint(){
        System.out.print("车已停满，请晚点再来\n");
    }

    public String parkWhenNotFullPrint() {
        System.out.print("请输入车牌号:");
        return getInput.get();
    }

    public void partSuccess(Ticket ticket){
        System.out.print("停车成功，您的小票是：\n");
        System.out.print(ticket.getUUID());
    }

    public Ticket unPark() {
        System.out.print("请输入小票编号：");

        return new Ticket(getInput.get());
    }

    public void unParkSuccess(Car car) {
        System.out.print("车已取出，您的车牌号是:"+car.getCarid());
    }

    public void unParkFail() {
        System.out.print("非法小票，无法取出车，请查证后再输\n");
    }
}
