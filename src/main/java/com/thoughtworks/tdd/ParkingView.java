package com.thoughtworks.tdd;

public class ParkingView {

    public ParkingView() { }

    public String showBasePage() {
        return "1.停车服务\n" +
                "2.停车场管理\n" +
                "请输入您要进入的页面：\n";
    }

    public String showMainUI() {
        return "1.停车\n2.取车\n请输入您要进行的操作：\n";
    }

    public String showManagePage() {
        return "1.查看停车场详情\n" +
                "2.添加停车场\n" +
                "3.删除停车场\n";
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

    public String showAddLot() {
        return "请输入你套添加的停车场信息（格式为：名称，车位）：\n";
    }

    public String showDelLot() {
        return "请输入需要删除的被管理停车场ID:\n";
    }

    public String showAddSuccess() {
        return "停车场添加成功！\n";
    }

    public String delLotSuccess() {
        return "停车场删除成功！\n";
    }

    public String delFail() {
        return "停车场添加失败，原因：";
    }
    public String delFailNotExist() {
        return delFail() + "此停车场不存在！\n";
    }

    public String delFailNotEmpty() {
        return delFail()+"此停车场中，依然停有汽车，无法删除！";
    }

}
