package com.thoughtworks.tdd;

public class ParkingControl {
    private final ParkingView parkingView;
    private final ParkingModel parkingModel;

    private Response response;
    private GetInput getInput;

    private final String PARK = "1";
    private final String UNPARK = "2";
    private final int PARKCOMMAND = 1;
    private final int UNPARKCOMMAND = 2;


    public ParkingControl(ParkingView _parkingView, ParkingModel _parkingModel, GetInput _getInput) {
        parkingView = _parkingView;
        parkingModel = _parkingModel;
        getInput = _getInput;
        response = new Response();
    }

//    public void start() {
//        try {
//            int commandNumber = parkingView.start();
//            doCommand(commandNumber);
//        }catch (InputNotValidException inputNotValidException){
//        }
//    }

    public void start(){
        response.print(parkingView.showMainUI());
        try {
            int commandNumber = getCommandNumber();
            doCommand(commandNumber);
        }catch (InputNotValidException inputNotValidException){
            response.print(parkingView.printInputErr());
        }
    }

    private void unPark() {
        response.print(parkingView.unPark());
        Ticket ticket = new Ticket(getInput.get());
        try{
            Car car = parkingModel.unPark(ticket);
            response.print(parkingView.unParkSuccess(car));
        }catch (CannotFindTheCarException cannotFindTheCarException){
            response.print(parkingView.unParkFail());
        }
    }

    public void park(){
        boolean canPark = parkingModel.notFull();
        if(canPark){
            response.print(parkingView.parkWhenNotFullPrint());
            String carID = getInput.get();
            Ticket ticket = parkingModel.park(new Car(carID));
            response.print(parkingView.partSuccess(ticket));
        }else {
            response.print(parkingView.parkWhenFullPrint());
        }
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

    public void doCommand(int command) {
        switch (command){
            case PARKCOMMAND:
                park();break;
            case UNPARKCOMMAND:
                unPark();break;
        }
    }

}
