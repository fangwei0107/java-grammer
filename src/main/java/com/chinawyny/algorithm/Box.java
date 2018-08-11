package com.chinawyny.algorithm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private T t;
    public Box(T t){
        this.t = t;
    }
    public void print(){
        System.out.println(t.getClass().getName());
    }

    private static <T> T pick(T a1, T a2) {
        return a2;
    }

    public static void boxTest(Box<Number> numberBox) {}

    public static void printList(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + "");
        System.out.println();
    }

    public static void main(String[] args) {
        Serializable s = Box.pick("d", new ArrayList<String>());
        System.out.println(s.getClass().getName());
        List<String> list = new ArrayList<>();
        List<? extends Integer> lb = new ArrayList<>();
        List<? extends Number> la = lb;
        la = Collections.singletonList(new Integer(1));
    }



}
