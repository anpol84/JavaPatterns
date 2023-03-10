package mirea.practice.practice3;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyArrayList<Integer> list = new MyArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 5000; i++){
                list.add(1);
                list2.add(1);
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 5000; i++){
                list.add(1);
                list2.add(1);
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println(list.size());
        System.out.println(list2.size());

        MySet<Integer> set = new MySet<>();
        Set<Integer> set2 = new HashSet<>();
        Thread thread3 = new Thread(() -> {
           for (int i = 0; i < 5000; i++){
               set.add(i);
               set2.add(i);
           }
        });
        Thread thread4 = new Thread(() -> {
           for (int i = 5000; i < 10000; i++){
               set.add(i);
               set2.add(i);
           }
        });
        thread3.start();
        thread4.start();
        Thread.sleep(1000);
        System.out.println(set.size());
        System.out.println(set2.size());
    }

}
