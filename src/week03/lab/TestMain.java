package week03.lab;

import java.util.Random;
import java.util.Scanner;

public class TestMain {
    static void week03Lab() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("무슨 커피 드릴까요? ");
        String menu = scanner.nextLine();

        int price = switch(menu) {
            case "Americano", "Espresso" -> 2500;
            case "Cappuccino", "CafeLatte" -> 3500;
            default -> -1;
        };

        if (price > 0) {
            System.out.println(menu + "는 " + price + "원입니다.");
        }
        else {
            System.out.println("판매하는 제품이 아닙니다.");
        }
    }
    // 가위바위보 승패 파악, if문 주렁주렁 작성 말고 수식 찾아내라. 3번 혹은 2승 먼저할때까지
    static void week03RSP() {
        System.out.println("가위(0), 바위(1), 보(2) 중 하나를 입력하세요.");
        System.out.println("3판 2선승제로 진행됩니다. 먼저 2승을 하는 사람이 승리합니다!");
        System.out.println();

        int computerWin = 0;
        int userWin = 0;
        int draw = 0;

        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        while (!(computerWin >= 2 || userWin >= 2)) {
            System.out.println("--- 현재 스코어 ---");
            System.out.println("사용자: " + userWin + "승, 컴퓨터: " + computerWin + "승");

            System.out.print("입력 : ");
            int userDecision = scanner.nextInt();
            int computerDecision = r.nextInt(3);

            if (userDecision < 0 || userDecision > 2) {
                System.out.println("올바르지 않은 입력입니다!");
                continue;
            }

            System.out.print("사용자: " + switch (userDecision) {
                case 0 -> "가위";
                case 1 -> "바위";
                case 2 -> "보";
                default -> "올바르지 않은 입력";
            } + ", ");
            System.out.println("컴퓨터: " + switch (computerDecision) {
                case 0 -> "가위";
                case 1 -> "바위";
                case 2 -> "보";
                default -> "올바르지 않은 출력";
            });

            System.out.println(switch (((userDecision - computerDecision) + 3) % 3) {
                case 2 -> "컴퓨터가 이겼습니다!";
                case 0 -> "비겼습니다!";
                case 1 -> "사용자가 이겼습니다!";
                default -> "오류!";
            });

            switch (((userDecision - computerDecision) + 3) % 3) {
                case 2 -> computerWin++;
                case 1 -> userWin++;
                default -> draw++;
            }
        }

        System.out.println();
        System.out.println("--- 최종 결과 ---");

        System.out.println(switch (userWin) {
            case 2 -> "축하합니다! 사용자가 이겼습니다!";
            default -> "아쉽지만 최종 승리자는 컴퓨터입니다.";
        });
    }

    static final int LOTTO_LENGTH = 6;
    static final int LOTTO_MAX = 45;

    static int[] generateLotto() {
        int[] lotto = new int[LOTTO_LENGTH];
        Random r = new Random();

        for(int i = 0; i < LOTTO_LENGTH; i++) {
            while(true) {
                int lottoNumber = r.nextInt(LOTTO_MAX) + 1;
                if (!hasConflict(lotto, lottoNumber, i)) {
                    lotto[i] = lottoNumber;
                    break;
                }
            }
        }

        return lotto;
    }

    static boolean hasConflict(int[] arr, int n, int idx) {
        for(int i = 0; i < idx; i++) {
            if (arr[i] == n) {
                return true;
            }
        }
        return false;
    }

    static int[] selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if(minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

        return arr;
    }

    static void printLotto(int[] arr) {
        System.out.print("로또 번호 : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void week03Lotto() {
        int[] lotto = generateLotto();
        int[] sortedLotto = selectionSort(lotto.clone());
        printLotto(sortedLotto);
    }

    static void main() {
        System.out.println("202611014 이승원");
//        week03Lab();
//        week03RSP();
        week03Lotto();
    }
}
