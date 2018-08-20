package com.chinawyny.reflectdemo;

public class Consumer {
    private long id;//私有的
    public String name;//共有的
    /*没参数构造体*/
    public Consumer() {
    }
    /*有参数构造体*/
    public Consumer(long id, String name) {
        this.id = id;
        this.name = name;
    }
    /*getter setter*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*私有的无参buy方法*/
    private static void buy() {
        System.out.println("私有的无参buy方法");
    }
    /*共有的有参有返回值consume方法*/
    public String consume(String giftName) {
        System.out.println("买了一件礼物： " + giftName);
        return giftName;
    }
}
