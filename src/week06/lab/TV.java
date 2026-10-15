package week06.lab;

public class TV extends HomeAppliance {
    private int channel = 7;

    public TV(String HAName) {
        super(HAName);
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void showStatus() {
        System.out.print("제품이름 : " + getHAName() + " 전원 : " + isHAPower());
        if(isHAPower()) {
            System.out.print(" 채널 : " + this.channel);
        }
        System.out.println();
    }

    @Override
    public void menu() {
        while(true) {
            System.out.print("1) 전원 설정 2) 채널 변경 3) 제어 종료 선택 : ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1 -> setHAPower(!isHAPower());
                case 2 -> {
                    if(isHAPower()) {
                        System.out.print("변경할 채널 : ");
                        setChannel(scan.nextInt());
                    }
                }
                case 3 -> {
                    System.out.println(getHAName() + " 제어 종료");
                    return;
                }
                default -> System.out.println("메뉴를 다시 입력해 주세요.");
            }
            showStatus();
        }
    }

//    @Override
//    public void turnOn() {
//        this.setHAPower(true);
//    }
//
//    @Override
//    public void turnOff() {
//        this.setHAPower(false);
//    }
//
//    @Override
//    public void control() {
//        this.menu();
//    }
}
