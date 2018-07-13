package com.thoughtworks.tdd;

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

    public void start(){
        showMainUI();
        try{
           int commandNumber = getCommandNumber();
           doNext(commandNumber);
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

    public void doNext(int commandNumber) {
        if(commandNumber == PARKCOMMAND){

        }else {

        }
    }
    public void printInputErr() {
        System.out.print("非法指令，请查证后再输\n");
    }

}
