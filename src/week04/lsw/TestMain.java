package week04.lsw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestMain {
    static void example01() {
        String[] stdNames = {"홍길동", "고길동", "김길동", "이길동"};
        int[][] scores = {
                {10, 20, 30, 0},
                {20, 30, 40, 0},
                {30, 40, 50, 0},
                {10, 10, 20, 0},
        };
        getTotalScore(scores);
        printScores(stdNames, scores);
    }

    static void getTotalScore(int[][] scores) {
//        for(int[] std : scores) {
//            for(int i = 0; i < std.length - 1; i++) {
//                std[std.length  - 1] += std[i];
//            }
//        }
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length - 1; j++) {
                scores[i][scores[i].length - 1] += scores[i][j];
            }
        }
    }

    static void printScores(String[] stdNames, int[][] scores) {
        for(int i = 0; i < scores.length; i++) {
            System.out.print(stdNames[i] + " >> ");
            for(int j = 0; j < scores[i].length; j++) {
                if(j == scores[i].length - 1) {
                    System.out.print(": ");
                }
                System.out.print(scores[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void example02() {
        String[] stdNames;
        int[][] scores;

        File file = new File("res/scores.txt");
        try {
            Scanner scanner = new Scanner(file);

            final int ROW = scanner.nextInt();
            stdNames = new String[ROW];
            scores = new int[ROW][];
            int std = 0;

            while(scanner.hasNext()) {
                final int COL = scanner.nextInt();
                scores[std] = new int[COL + 1];

                stdNames[std] = scanner.next();
                for(int i = 0; i < scores[std].length - 1; i++) {
                    scores[std][i] = scanner.nextInt();
                }
                std++;
            }

            getTotalScore(scores);
            printScores(stdNames, scores);
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }

    static void main() {
        System.out.println("202611014 이승원");
//        example01();
//        example02();
        TV tv = new TV();
//        TV tv2 = new TV();
//        tv2 = tv;
//        System.out.println("tv : " + tv);
//        System.out.println("tv2 : " + tv2);
        tv.powerOnOff();
        tv.channelUp();
        tv.channelUp();
        tv.channelUp();
        tv.channelUp();
        tv.channelUp();
        tv.channelUp();
        tv.channelDown();
        tv.channelDown();

        TV tv2 = tv;
        tv2.powerOnOff();
        tv.channelUp();
    }
}
