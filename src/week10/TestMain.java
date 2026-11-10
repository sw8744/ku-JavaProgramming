package week10;

public class TestMain {
    static void main() {
//        Rect rect1 = new Rect(2, 3);
//        Rect rect2 = new Rect(3, 2);
//        Rect rect3 = new Rect(3, 3);
//
//        System.out.println(rect1 == rect2 ?"같다" :"다르다");
//        System.out.println(rect1.equals(rect2) ?"같다" :"다르다");
//        System.out.println(rect2.equals(rect3) ?"같다" :"다르다");

//        example01();
        example02();
    }

    private static void example02() {
        WordManager manager = new WordManager("홍길동");
        manager.makeVoc("res/words.txt");
    }

    private static void example01() {
        MyArray<Integer> arr1 = new MyArray<>(5);
        arr1.add(10);
        arr1.add(20);
        arr1.add(30);
        System.out.println(arr1);

        MyArray<String> arr2 = new MyArray<>(5);
        arr2.add("red");
        arr2.add("green");
        System.out.println(arr2);

        MyArray<Word> arr3 = new MyArray<>(5);
        arr3.add(new Word("red", "빨강"));
        arr3.add(new Word("green", "초록"));
        System.out.println(arr3);
    }
}
