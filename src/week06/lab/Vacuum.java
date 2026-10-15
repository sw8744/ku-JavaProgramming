package week06.lab;

public class Vacuum extends HomeAppliance implements IoTInterface {
    private int power = 1;

    public Vacuum(String HAName) {
        super(HAName);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void showStatus() {
        System.out.print("제품이름 : " + getHAName() + " 전원 : " + isHAPower());
        if(isHAPower()) {
            System.out.print(" 세기 : " + getPower());
        }
        System.out.println();
    }

    @Override
    public void menu() {
        while(true) {
            System.out.print("1) 전원 설정 2) 세기 설정 3) 제어 종료 선택 : ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1 -> setHAPower(!isHAPower());
                case 2 -> {
                    System.out.print("세기 : ");
                    setPower(scan.nextInt());
                }
                case 3 -> {
                    System.out.println("전원 종료");
                    return;
                }
            }
            showStatus();
        }
    }

    @Override
    public void turnOn() {
        System.out.println("청소기를 제어합니다.");
        this.setHAPower(true);
    }

    @Override
    public void turnOff() {
        System.out.println("청소기 제어 종료!!");
        this.setHAPower(false);
    }

    @Override
    public void control() {
        this.menu();
    }
}
