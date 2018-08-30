package com.chinawyny.algorithm.singleton;

/**
 * 不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 */
public enum EnumSingleton {
    INSTANCE;

    public void whateverMethod(){}
}
