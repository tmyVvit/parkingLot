package com.thoughtworks.tdd;

public class ParkingView {

    public ParkingView() { }

    public String showMainUI() {
        return "1.停车\n2.取车\n请输入您要进行的操作：\n";
    }

    public String printInputErr() {
        return "非法指令，请查证后再输\n";
    }

    public String parkWhenFullPrint(){
        return "车已停满，请晚点再来\n";
    }

    public String parkWhenNotFullPrint() {
        return "请输入车牌号:\n";
    }

    public String partSuccess(Ticket ticket){
        return "停车成功，您的小票是：\n"+ticket.getUUID()+"\n";
    }

    public String unPark() {
        return "请输入小票编号：\n";
    }

    public String unParkSuccess(Car car) {
        return "车已取出，您的车牌号是:"+car.getCarid()+"\n";
    }

    public String unParkFail() {
        return "非法小票，无法取出车，请查证后再输\n";
    }
}
