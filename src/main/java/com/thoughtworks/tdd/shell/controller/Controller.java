package com.thoughtworks.tdd.shell.controller;

import com.thoughtworks.tdd.shell.Request;

public abstract class Controller {
    protected final String BASE = "base";
    protected final String PARKSERVICE = "main";
    protected final String PARKMANAGE = "parkManage";
    protected final String PARK = "park";
    protected final String UNPARK = "unPark";
    protected final String CHECKLOTINFO = "checklotinfo";
    protected final String ADDLOT = "addLot";
    protected final String DELLOT = "delLot";


    public abstract String doCommand(Request request);
    public abstract void printPage();
}
