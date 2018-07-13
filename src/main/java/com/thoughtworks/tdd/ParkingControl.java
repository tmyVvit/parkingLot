package com.thoughtworks.tdd;

public class ParkingControl {
    private final ParkingView parkingView;
    private final ParkingModel parkingModel;


    public ParkingControl(ParkingView parkingView, ParkingModel parkingModel) {
        this.parkingView = parkingView;
        this.parkingModel = parkingModel;
    }

    public void start() {
        try {
            int commandNumber = parkingView.start();
            if(commandNumber == 1){
                park();
            }else if(commandNumber == 2){
                unpark();
            }
        }catch (InputNotValidException inputNotValidException){
            start();
        }
    }

    private void unpark() {
        Ticket ticket = parkingView.unPark();
        try{
            Car car = parkingModel.unPark(ticket);
            parkingView.unParkSuccess(car);
        }catch (CannotFindTheCarException cannotFindTheCarException){
            parkingView.unParkFail();
        }
        start();
    }

    public void park(){
        boolean canPark = parkingModel.notFull();
        if(canPark){
            String carID = parkingView.parkWhenNotFullPrint();
            Ticket ticket = parkingModel.park(new Car(carID));
            parkingView.partSuccess(ticket);
        }else {
            parkingView.parkWhenFullPrint();
        }
        start();
    }

}
