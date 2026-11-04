package week10;

public class TestMain {
    static void main() {
        Rect rect1 = new Rect(2, 3);
        Rect rect2 = new Rect(3, 2);
        Rect rect3 = new Rect(3, 3);

        System.out.println(rect1 == rect2 ?"같다" :"다르다");
        System.out.println(rect1.equals(rect2) ?"같다" :"다르다");
        System.out.println(rect2.equals(rect3) ?"같다" :"다르다");

    }
}
