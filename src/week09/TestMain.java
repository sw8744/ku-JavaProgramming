package week09;

import java.util.Random;

public class TestMain {
    static void main(String[] args) {
//        example01();
        example02(args);
    }

    private static void example02(String[] args) {
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            System.out.println(num1 + ", " + num2);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("인자 개수가 부족함");
        } catch (NumberFormatException e) {
            System.out.println("숫자로 바꿀 수 없음");
        }
    }

    private static void example01() {
        Random rand = new Random();
        int num = 100;
        while(true) {
            try {
                int result = num / rand.nextInt(100);
                if (result > 10) {
                    return;
                } else {
                    System.out.println("result = " + result);
                }

            } catch(ArithmeticException e) {
//                ArithmeticException e = new ArithmeticException("/ by zero");
//                System.out.println("0으로 나눌 수 없음");
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                System.out.println("다음 연산을 수행합니다.");
            }
        }
    }
}
