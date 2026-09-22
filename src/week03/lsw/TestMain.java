package week03.lsw;

import java.util.Scanner;

public class TestMain {
    static void example01() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("월(1 ~ 12)을 입력하시오: ");
        int month = scanner.nextInt(); // 정수로 월 입력
        switch(month) {
            case 3, 4, 5 ->
                    System.out.println("봄입니다.");
            case 6, 7, 8 ->
                    System.out.println("여름입니다.");
            case 9, 10, 11 ->
                    System.out.println("가을입니다.");
            case 12, 1, 2 ->
                    System.out.println("겨울입니다.");
            default ->
                    System.out.println("잘못된 입력입니다.");
        }
    }

    static void example02() {
        int num = 5;

        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("--------------");

        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("--------------");

        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("--------------");

        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 1; i <= num - 1; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2 * (num - i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    static void selectionSort(int[] arr) {
        // 0 ~ arr.length - 2 까지 반복
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if(i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    static void printArray(int[] arr) {
        for(int n: arr) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }

    static void main() {
        System.out.println("202611014 이승원");
//        example01();
//        example02();

        int[] arr = {10, 5, 9, 7, 6, 3};

        System.out.print("정렬 전 : ");
        printArray(arr);

        selectionSort(arr.clone());

        System.out.print("정렬 후 : ");
        printArray(arr);
    }
}
