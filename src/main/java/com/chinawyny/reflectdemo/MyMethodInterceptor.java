package com.chinawyny.reflectdemo;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyMethodInterceptor implements MethodInterceptor {

    /**
     *
     * @param o 代理对象
     * @param method 被代理方法
     * @param objects 被代理方法参数
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("object: " + o.getClass());
        System.out.println("method: " + method);
        System.out.println("objects: " + Arrays.toString(objects));
        System.out.println("methodProxy" + methodProxy);
        return methodProxy.invokeSuper(o, objects);
    }
}
