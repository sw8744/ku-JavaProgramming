package week10.lab01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMain {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("끝말잇기 게임을 시작합니다...");
        int peopleNumber;
        while(true) {
            try {
                System.out.print("게임에 참가할 인원은 몇명입니까 >> ");
                peopleNumber = sc.nextInt();
                sc.nextLine();
                if(peopleNumber <= 0) {
                    System.out.println("인원은 양수여야 합니다!");
                }
                else {
                    break;
                }
            } catch(InputMismatchException e) {
                System.out.println("정수가 아닙니다!");
            }
        }

        String[] people = new String[peopleNumber];
        for(int i = 0; i < peopleNumber; i++) {
            System.out.print("참가자의 이름을 입력하세요 >> ");
            people[i] = sc.nextLine();
        }

        StringBuilder previousWord = new StringBuilder("건국대");
        System.out.println("시작하는 단어는 건국대입니다.");

        int round = 0;
        while(true) {
            System.out.print(people[round % peopleNumber] + " >> ");
            String word = sc.nextLine().strip();
            if(word.charAt(0) != previousWord.charAt(previousWord.length() - 1)) {
                System.out.println(people[round % peopleNumber] + "이 졌습니다.");
                break;
            }
            else {
                previousWord.delete(0, previousWord.length());
                previousWord.insert(0, word);
                round++;
            }
        }
    }
}
