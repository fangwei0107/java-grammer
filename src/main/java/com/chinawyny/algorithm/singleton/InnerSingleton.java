package com.chinawyny.algorithm.singleton;

/**
 * 利用静态内部类，某个线程在调用该方法时会创建一个实例化对象。
 * 利用类的静态变量初始化的时候是线程安全的且唯一
 */
public class InnerSingleton {

    private static class SingletonHolder {
        private static InnerSingleton instance = new InnerSingleton();
    }

    public synchronized static InnerSingleton getInstance() {
        return SingletonHolder.instance;
    }

    private InnerSingleton() {}

}
