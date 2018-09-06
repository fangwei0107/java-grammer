package com.chinawyny.algorithm.singleton;

public class LazySingleton {

    private static volatile LazySingleton instance;

    public static LazySingleton getInstance() {
        // 第一次检查是确保之前是一个空对象，而非空对象就不需要同步了
        if (null == instance) {
            synchronized (LazySingleton.class) {
                /**
                 * 如果不加第二次空对象检查，两个线程同时获取同步代码块，一个线程进入同步代码块，另一个线程就会等待，
                 * 而这两个线程就会创建两个实例化对象，所以需要在线程进入同步代码块后再次进行空对象检查，才能确保只创建一个实例化对象。
                 */
                if (null == instance) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    private LazySingleton() {
    }
}
