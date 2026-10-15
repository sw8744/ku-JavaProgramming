package week06.lab;

public class Home {
    private HomeAppliance[] devices;
    private int count = 0;

    public Home(int capacity) {
        devices = new HomeAppliance[capacity];
    }

    public void addHA(HomeAppliance ha) {
        if(this.count < devices.length) {
            devices[count++] = ha;
        }
        else {
            System.out.println("더 이상 공간 없음");
        }
    }

    public void showAllStatus() {
        System.out.println("우리 집 가전제품");
        for(HomeAppliance ha : devices) {
            if(ha != null) {
                ha.showStatus();
            }
            else {
                break;
            }
        }
    }

    public void open() {
        while(true) {
            for(int i = 0; i < this.count; i++) {
                System.out.println((i + 1) + ") " + devices[i].getHAName());
            }
            System.out.println("0) 종료");
            System.out.print("선택 : ");
            int choice = HomeAppliance.scan.nextInt();
            if(choice == 0) {
                System.out.println("종료");
                return;
            }
            devices[choice - 1].menu();
            showAllStatus();
        }
    }

    public IoTInterface connect() {
        int[] ioTAvailables = new int[count];
        int count = 0;
        System.out.println("원격 제어 가능 제품 리스트");
        for(int i = 0; i < devices.length; i++) {
            if(devices[i] != null && devices[i] instanceof IoTInterface) {
                ioTAvailables[count++] = i;
                System.out.println((i + 1) + ") " + devices[i].getHAName());
            }
        }
        System.out.print("원격 제어할 가전제품을 선택 : ");
        int choice = HomeAppliance.scan.nextInt();
        if(choice >= 1 && choice <= devices.length) {
            boolean hasNumber = false;
            for(int num : ioTAvailables) {
                if(num == choice - 1) {
                    hasNumber = true;
                    break;
                }
            }
            if(hasNumber) {
                return (IoTInterface) devices[choice - 1];
            }
        }
        else {
            System.out.println("올바르지 않은 번호입니다!");
        }
        return null;
    }
}
