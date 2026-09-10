package week02.example01;

import java.io.IOException;
import java.util.Scanner;

public class TestMain {
    static void example01() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("학번 : ");
        String sid = scanner.next();
        scanner.nextLine();

        System.out.print("이름 : ");
        String name = scanner.nextLine();

        System.out.print("나이 : ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("주소 : ");
        String address = scanner.nextLine();

        System.out.println("학번 : " + sid);
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("주소 : " + address);
    }

    static void main() throws IOException {
        example01();
//        int code;
//        while((code = System.in.read()) != -1) {
//            System.out.println("code : " + code + " -> " + (char)code);
//        }
//        code = System.in.read();
//        System.out.println("code : " + code + " -> " + (char)code);
//        code = System.in.read();
//        System.out.println("code : " + code + " -> " + (char)code);
    }
}
