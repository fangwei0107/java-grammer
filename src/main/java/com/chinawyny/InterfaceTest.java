package com.chinawyny;

public interface InterfaceTest {
    static int a = 3;
    
    static void a() {
        System.out.println(1);
    }
    
    default void b() {}
}
