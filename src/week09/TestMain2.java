package week09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMain2 {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(choice != 4) {
            try{
                System.out.println("1) 커피 2) 빵 3) 물 4) 종료");
                System.out.print("선택 : ");
                choice = scanner.nextInt();
                if(!(choice >= 1 && choice <= 4)) {
//                System.out.println("메뉴를 확인해 주세요.");
                    throw new MenuRangeCheckException("메뉴를 확인해 주세요.");
                }
            } catch(MenuRangeCheckException e) {
                System.out.println(e.getMessage());
            } catch(InputMismatchException e) {
                System.out.println("정수를 입력해야 합니다.");
                scanner.nextLine();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
