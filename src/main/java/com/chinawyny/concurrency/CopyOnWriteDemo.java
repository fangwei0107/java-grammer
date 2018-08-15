package com.chinawyny.concurrency;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> integers = new CopyOnWriteArrayList<>();
        new Thread(() -> {
            for (int i = 0;i < 10;i++) {
                integers.add(i);
                try {
                    System.out.println(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 10;i < 20;i++) {
                integers.add(i);
                try {
                    System.out.println(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(20000);
        System.out.println("===================================");
        integers.forEach(System.out::println);
    }
}
