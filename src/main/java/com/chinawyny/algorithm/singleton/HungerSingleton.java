package com.chinawyny.algorithm.singleton;

/*
饿汉模式：线程安全，耗费资源。
分析：饿汉式单例模式只要调用了该类，就会实例化一个对象，
但有时我们并只需要调用该类中的一个方法，而不需要实例化一个对象，所以饿汉式是比较消耗资源的。
*/
public class HungerSingleton {
    /*
        该对象的引用不可修改
    */
    private static final HungerSingleton instance = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return instance;
    }

    private HungerSingleton() {
    }

}
