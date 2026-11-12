package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class WordManager {
    String userName;
    List<Word> voc = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public WordManager(String userName) {
        this.userName = userName;
    }

    public void makeVoc(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] temp = str.split("\t");
                voc.add(new Word(temp[0].trim(), temp[1].trim()));
            }
            System.out.println(userName + "의 단어장 생성완료");
            menu();
        } catch (FileNotFoundException e) {
            System.out.println("파일의 위치 확인 요망");
        }
    }

    private void menu() {
        int choice = 0;
        while(choice != 3) {
            System.out.println("1) 단어뜻검색 2) 부분단어검색 3) 종료");
            System.out.print("메뉴 선택 : ");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1 -> searchWord1();
                case 2 -> searchWord2();
                case 3 -> {
                    System.out.println("단어장 종료");
                    return;
                }
            }
        }
    }

    private void searchWord2() {
        System.out.println("------- 부분단어 검색 -------");
        System.out.print("검색할 단어 입력 : ");
        String word = scan.nextLine();
        for(Word w : voc) {
            if(w != null) {
                if(w.eng.startsWith(word)) {
                    System.out.println(w.eng + " : " + w.kor);
                }
            }
        }
    }

    private void searchWord1() {
        System.out.println("------- 단어 뜻 검색 -------");
        System.out.print("검색할 단어 입력 : ");
        String word = scan.nextLine();
        for(Word w : voc) {
            if(w != null) {
                if(w.eng.equals(word.trim())) {
                    System.out.println("단어 뜻 : " + w.kor);
                }
            }
        }
    }


}
