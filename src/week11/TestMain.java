package week11;

import java.util.*;

public class TestMain {
    static void main() {
//        example01();
//        example02();
//        example03();
        example04();
    }

    private static void example04() {
        Map<String, Word> map = new HashMap<>();
        map.put("red1", new Word("red1", "빨강1"));
        map.put("red2", new Word("red2", "빨강2"));
        map.put("red3", new Word("red3", "빨강3"));
        map.put("red2", new Word("red2", "빨강색2"));

        Word w = new Word("blue", "파랑");
        map.put("blue", w);
        map.put("skyblue", w);

//        System.out.println(map.get("red2").kor);
        Set<Map.Entry<String, Word>> set = map.entrySet();
        Iterator<Map.Entry<String, Word>> it = set.iterator();
        while(it.hasNext()) {
            Map.Entry<String, Word> entry = it.next();
            String key = entry.getKey();
            Word value = entry.getValue();
            System.out.println(key + " : " + value);
        }
        System.out.println("------------------");
        Set<String> keyset = map.keySet();
        for(String key : keyset) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    private static void example03() {
        Set<Word> set = new HashSet<>();
        set.add(new Word("red1", "빨강1"));
        set.add(new Word("red2", "빨강2"));
        set.add(new Word("red2", "빨강2"));
        set.add(new Word("red4", "빨강4"));

        Set<Word> set2 = new HashSet<>();
        set2.add(new Word("red1", "빨강1"));
        set2.add(new Word("red2", "빨강2"));
        set2.add(new Word("red3", "빨강3"));

        System.out.println(set);

        Set<Word> intersection = new HashSet<>(set2);
        intersection.retainAll(set);
        System.out.println(intersection);

        Set<Word> union = new HashSet<>(set2);
        union.addAll(set);
        Iterator<Word> it = union.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }

    private static void example02() {
        List<Word> list = new LinkedList<>();
        list.add(new Word("red1", "빨강1"));
        list.add(new Word("red2", "빨강2"));
        list.add(new Word("red3", "빨강3"));
        list.add(new Word("red4", "빨강4"));

        System.out.println(list);

        ListIterator<Word> it = list.listIterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("-----------------");
        while(it.hasPrevious()) {
            System.out.println(it.previous());
        }

//        Iterator<Word> it = list.iterator();
//        while(it.hasNext()) {
//            Word w = it.next();
//            if(w.eng.equals("red2")) {
//                it.remove();
//            }
//        }
//        System.out.println(list);
    }

    private static void example01() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        long startTime = System.nanoTime();

        for(int i = 0; i < 10000; i++) {
            list1.add(i);
        }

        long endTime = System.nanoTime();

        System.out.println("ArrayList : " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();

        for(int i = 0; i < 10000; i++) {
            list2.add(i);
        }

        endTime = System.nanoTime();

        System.out.println("LinkedList : " + (endTime - startTime) + "ns");
    }
}
