package com.thoughtworks.tdd.shell;

import com.sun.org.apache.regexp.internal.REUtil;
import com.thoughtworks.tdd.shell.controller.*;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private HashMap<String, Controller> controllerMap = new HashMap<>();
    private Map<String, Controller> cMap = new HashMap<>();
    private ParkingModel parkingModel;
    private String initCurrent = "base";
    private String current;
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

        regist("base", new BaseController(response));
        regist("base/service", new ParkServiceController(response));
        regist("base/service/1", new TryParkController(response, parkingModel));
        regist("base/service/1/*", new ParkController(response, parkingModel));
        regist("base/service/2", new TryUnParkController(response));
        regist("base/service/2/*", new UnParkController(response, parkingModel));
        regist("base/manage", new ParkManageController(response, parkingModel));
        regist("base", new BaseController(response));
        regist("err", new ErrController(response));

    }

    public void regist(String str, Controller controller) {
        cMap.put(str, controller);
    }
    public void init(){
        current = initCurrent;
        controllerMap.get(current).doCommand(new Request());
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
    public void startNew(Request request) {
        String newPath = getPagePath(request);
        String next = cMap.get(newPath).doCommand(request);
        current = newPath;
        if(next != "" && next.contains("forwards:")){
            current = doNextPath(next, request);
        }
    }

    private String doNextPath(String next, Request request) {
        current = next.split(":")[1];
        cMap.get(current).doCommand(request);
        return current;
    }

    public String getPagePath(Request request) {
        String path = current;
        switch (path) {
            case "base": path = getBasePath(request); break;
            case "base/service": path = getServicePath(request);break;
            case "base/manage": path = getManagePath(request);break;
            default: path += "/*"; break;
        }
        return path;
    }

    private String getManagePath(Request request) {
        String path = current;
        switch (request.getCommand()) {
            case "1": path += "/1"; break;
            case "2": path += "/2"; break;
            case "3": path += "/3"; break;
            default: path = "err";
        }
        return path;
    }

    private String getServicePath(Request request) {
        String path = current;
        switch (request.getCommand()) {
            case "1": path += "/1"; break;
            case "2": path += "/2"; break;
            default: path = "err";
        }
        return path;
    }

    private String getBasePath(Request request) {
        String command = request.getCommand();
        StringBuilder path = new StringBuilder("base");
        switch (command) {
            case "1": path.append("/service"); break;
            case "2": path.append("/manage"); break;
            default: return "err";
        }
        return path.toString();
    }


    public void printErr() {
        response.print("非法指令，请查证后再输\n");
    }
}
