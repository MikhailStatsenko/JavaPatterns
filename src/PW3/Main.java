package PW3;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        testMap();
        testSet();
    }

    public static void testMap() throws InterruptedException {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> myMap = new MyMap<>();

        Thread one = new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                map.put(i, i);
                myMap.put(i, i);
            }
        });
        Thread two = new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                map.put(i, i);
                myMap.put(i, i);
            }
        });
        Thread three = new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                map.put(i, i);
                myMap.put(i, i);
            }
        });
        one.start();
        two.start();
        three.start();

        Thread.sleep(2000);
        System.out.println(map.size());
        System.out.println(myMap.size());
    }

    public static void testSet() throws InterruptedException {
        Set<Integer> set = new HashSet<>();
        Set<Integer> mySet = new MySet<>();
        Thread one = new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                set.add(i);
                mySet.add(i);
            }
        });
        Thread two = new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                set.add(i);
                mySet.add(i);
            }
        });
        Thread three = new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                set.add(i);
                mySet.add(i);
            }
        });
        one.start();
        two.start();
        three.start();

        Thread.sleep(2000);
        System.out.println(set.size());
        System.out.println(mySet.size());

    }
}
