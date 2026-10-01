package week04.lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestMain {
    static void week04Rank() {
        String[] stdNames;
        int[][] scores;
        int[] sums;
        double[] avgs;

        File file = new File("res/scores.txt");
        try {
            Scanner scanner = new Scanner(file);

            final int ROW = scanner.nextInt();
            stdNames = new String[ROW];
            scores = new int[ROW][];
            sums = new int[ROW];
            avgs = new double[ROW];
            int std = 0;

            while(scanner.hasNext()) {
                final int COL = scanner.nextInt();
                scores[std] = new int[COL];
                int scoreSum = 0;

                stdNames[std] = scanner.next();
                for(int i = 0; i < scores[std].length; i++) {
                    scores[std][i] = scanner.nextInt();
                    scoreSum += scores[std][i];
                }

                avgs[std] = (double) scoreSum / COL;
                std++;
            }
            int[] ranks = getRank(avgs);
            sums = getTotalScore(scores);
            printScores(stdNames, scores, sums, avgs, ranks);
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }

    static int[] getTotalScore(int[][] scores) {
        int[] sums = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                sums[i] += scores[i][j];
            }
        }
        return sums;
    }

    static int[] getRank(double[] avgs) {
        int[] ranks = new int[avgs.length];
        double[] sortedAvgs = selectionSortReverse(avgs.clone());

        for(int i = 0; i < avgs.length; i++) {
            for(int j = 0; j < sortedAvgs.length; j++) {
                if(avgs[i] == sortedAvgs[j]) {
                    if(i > 0 && avgs[i] == avgs[i - 1]) {
                        ranks[i] = j;
                    }
                    else {
                        ranks[i] = j + 1;
                    }
                }
            }
        }

    return ranks;
    }

    static double[] selectionSortReverse(double[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }

            if(maxIndex != i) {
                double temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }
        }

        return arr;
    }

    static void printScores(String[] stdNames, int[][] scores, int[] sums, double[] avgs, int[] ranks) {
        for(int i = 0; i < scores.length; i++) {
            System.out.print(stdNames[i] + " >> ");
            for(int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j] + " ");
            }
            System.out.print(": " + sums[i] + " ");
            System.out.print(": " + avgs[i] + " ");
            System.out.println(": " + ranks[i]);
        }
    }



    static void main() {
        System.out.println("202611014 이승원");
        week04Rank();
//        TV tv = new TV();
//        tv.powerOnOff();
//        for(int i = 0; i < 7; i++) {
//            tv.volumeUp();
//        }
//        for(int i = 0; i < 7; i++) {
//            tv.volumeDown();
//        }
    }
}
