package week02.lab;

public class TestMain {
    static final int COFFEE = 500;
    static final int MILK = 100;
    static final int WATER = 10;
    int getCost(int price, int count) {
        return price * count;
    }

    static void main() {
        int coffeeOrder = 5;
        int milkOrder = 3;
        int waterOrder = 1;

        TestMain greenjoa = new TestMain();
        TestMain bluejoa = new TestMain();

        int coffeeCost = greenjoa.getCost(COFFEE, coffeeOrder);
        int milkCost = greenjoa.getCost(MILK, milkOrder);
        int waterCost = greenjoa.getCost(WATER, waterOrder);
        int totalCost = coffeeCost + milkCost + waterCost;

        System.out.println("202611014 이승원");
        System.out.println("**** 주문 내역 ****");
        System.out.println("커피  : " + coffeeOrder + "잔 " + coffeeCost + "원");
        System.out.println("우유  : " + milkOrder + "잔 " + milkCost + "원");
        System.out.println("물   : " + waterOrder + "잔 " + milkCost + "원");
        System.out.println("*".repeat(20));
        System.out.println("총 주문금액 : " + totalCost + "원");
    }
}
