package com.chinawyny.reflectdemo;

public class SimpleMain {

    private static void consume(Interface iface) {
        iface.getMyName();
        String name = iface.getNameById("1");
        System.out.println("name: " + name);
    }

    public static void main(String[] args) {
        consume(new RealObject());
        System.out.println("========================================================");
        consume(new SimpleProxy(new RealObject()));
    }
}
