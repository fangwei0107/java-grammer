package com.chinawyny.reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
    public static void getProperty() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        try {
            /* 获取对象类型 */
            Class<?> clazz  = Class.forName("com.chinawyny.reflectdemo.Consumer");
            Object object = clazz.newInstance();
            /* 获取到所有属性 */
            Field[] field = clazz.getDeclaredFields();
            for (Field f:field) {
                //String fieldName = f.getName();// 取到属性名字
                //System.out.println(fieldName);
                System.out.println(f);
            }
            /* 获取到所有的方法，包括私有的，但不包括父类的 */
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m:methods){
                //String methodName = m.getName();
                //System.out.println(methodName);
                System.out.println(m);
            }
            /* 所有的构造体 */
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor c:constructors){
                System.out.println(c);
            }
            // 调用方法
            Method method = clazz.getDeclaredMethod("buy", null);//获取方法
            method.setAccessible(true);
            method.invoke(null);
            //得到属性
            Field aField = clazz.getDeclaredField("name"); //因为name变量是private的，所以不能用getField方法
            aField.setAccessible(true);
            aField.set(object,"二大爷");
            Object obj = aField.get(object);
            System.out.println(obj);
            // 得到构造器
            Constructor constructor = clazz.getDeclaredConstructor(long.class, String.class);
            constructor.newInstance(2016040221, "王小二");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        getProperty();
    }
}
