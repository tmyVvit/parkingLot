package com.thoughtworks.tdd.shell;

import com.thoughtworks.tdd.shell.controller.*;

import java.util.HashMap;

public class Router {
    private HashMap<String, Controller> controllerMap = new HashMap<>();
    private ParkingModel parkingModel;
    private String current = "base";
    private Response response = new Response();

    private final String BASE = "base";
    private final String PARKSERVICE = "main";
    private final String PARKMANAGE = "parkManage";
    private final String PARK = "park";
    private final String UNPARK = "unPark";
    private final String CHECKLOTINFO = "checklotinfo";
    private final String ADDLOT = "addLot";
    private final String DELLOT = "delLot";
    public Router(ParkingModel _parkingModel) {
        parkingModel = _parkingModel;
        controllerMap.put(BASE, new BaseController(response));
        controllerMap.put(PARKSERVICE, new ParkServiceController(response));
        controllerMap.put(PARK, new ParkController(response, parkingModel));
        controllerMap.put(UNPARK, new UnParkController(response, parkingModel));
        controllerMap.put(PARKMANAGE, new ParkManageController(response, parkingModel));
        controllerMap.put(ADDLOT, new ParkMAddLotController(response, parkingModel));
        controllerMap.put(DELLOT, new ParkMDelLotController(response, parkingModel));
    }

    public void init(){
        controllerMap.get(current).printPage();
    }
    public void start(Request request) {
        Controller ctl = controllerMap.get(current);
        current = ctl.doCommand(request);
        Controller next = controllerMap.get(current);
        if(next instanceof ParkController){
            current = ((ParkController) next).printPagep();
        }
        controllerMap.get(current).printPage();
    }

}
