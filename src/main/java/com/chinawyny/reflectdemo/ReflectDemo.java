package com.chinawyny.reflectdemo;

import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) {
//        System.out.println(int.class == Integer.TYPE);
//        System.out.println(Integer.class);
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            for (Method m : clazz.getDeclaredMethods()) {
//                m.invoke()
            }
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
