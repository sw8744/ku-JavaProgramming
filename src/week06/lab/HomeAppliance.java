package week06.lab;

import java.util.Scanner;

public abstract class HomeAppliance {
    private String HAName;
    private boolean HAPower = false;
    static Scanner scan = new Scanner(System.in);

    public HomeAppliance(String HAName) {
        this.HAName = HAName;
    }

    public String getHAName() {
        return HAName;
    }

    public void setHAName(String HAName) {
        this.HAName = HAName;
    }

    public boolean isHAPower() {
        return HAPower;
    }

    public void setHAPower(boolean HAPower) {
        this.HAPower = HAPower;
    }

    public abstract void showStatus();
    public abstract void menu();
}
