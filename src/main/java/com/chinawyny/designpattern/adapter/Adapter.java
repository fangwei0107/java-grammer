package com.chinawyny.designpattern.adapter;

interface Target {
    void request();
}

class Adaptee {
    public void specificRequest() {
        System.out.println("具体方法");
    }
}

public class Adapter extends Adaptee implements Target {
    public void request() {
        this.specificRequest();
    }

    public static void main(String[] args) {
        Target adapter = new Adapter();
        adapter.request();
    }
}


