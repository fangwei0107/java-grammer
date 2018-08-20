package com.chinawyny.reflectdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyMain {

    public static void consume(Interface iface) {
        iface.getMyName();
        String name = iface.getNameById("1");
        System.out.println("name: " + name);
    }

    public static void main(String[] args) {
        // 动态代理
        ClassLoader classLoader = Interface.class.getClassLoader();
        Class<?>[] interfaces = new Class[] {Interface.class};
        InvocationHandler handler = new DynamicProxyHandler(new RealObject());
        Interface proxy = (Interface) Proxy.newProxyInstance(classLoader, interfaces, handler);

        System.out.println("in dynamicproxyMain proxy: " + proxy.getClass());
        consume(proxy);
    }
}
