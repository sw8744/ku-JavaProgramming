package week06.lab;

public class TestMain {
    static void main() {
        System.out.println("202611014 이승원");
//        HomeAppliance appliance = new HomeAppliance("건국가전");
//        TV tv = new TV("건국 TV");
//        tv.menu();
//        IoTInterface ioTInterface = new TV("건국TV");

        Home home = new Home(5);
        home.addHA(new TV("건국TV"));
        home.addHA(new TV("대학TV"));
        home.addHA(new TV("세종TV"));
        home.addHA(new Vacuum("건국청소기"));
        home.addHA(new Vacuum("한양청소기"));
//        home.open();
        IoTInterface iot = home.connect();
        if(iot != null) {
            iot.turnOn();
            iot.control();
            iot.turnOff();
        }
        else {
            System.out.println("connect 실패!!");
        }
    }
}
