package com.chinawyny.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        int[] array = new int[100];
        for (int i = 1;i < array.length + 1; i++) {
            array[i - 1] = i;
        }
        for (final int i : array) {
            System.out.println("进入：" + i);
            executor.submit(new Runnable() {
                public void run() {
                    System.out.println("运行：" + i);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }
}
