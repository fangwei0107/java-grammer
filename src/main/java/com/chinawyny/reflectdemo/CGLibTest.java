package com.chinawyny.reflectdemo;

import net.sf.cglib.proxy.Enhancer;

public class CGLibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());
        HelloConcrete proxyHello = (HelloConcrete) enhancer.create();
//        System.out.println(proxyHello.getClass());

        System.out.println(proxyHello.sayHello("fw"));
    }
}
