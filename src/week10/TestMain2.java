package week10;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TestMain2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String id, phone, email;
        String idRegExp = "[a-z][a-z0-9]{4,11}";
        String phoneRegExp = "010-[0-9]{4}-[0-9]{4}";
        String emailRegExp =
                "\\w+@\\w+(\\.\\w+)+$";

        while (true) {
            System.out.print("아이디 >> ");
            id = sc.nextLine();
            if(Pattern.matches(idRegExp, id)) break;
            System.out.println("형식이 맞지 않습니다.");
        }
        while (true) {
            System.out.print("휴대폰 >> ");
            phone = sc.nextLine();
            if(Pattern.matches(phoneRegExp, phone)) break;
            System.out.println("형식이 맞지 않습니다.");
        }
        while (true) {
            System.out.print("이메일 >> ");
            email = sc.nextLine();
            if(Pattern.matches(emailRegExp, email)) break;
            System.out.println("형식이 맞지 않습니다.");
        }
        System.out.println("가입 완료!");
    }
}
