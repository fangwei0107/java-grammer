package com.chinawyny.designpattern.proxy;

interface Subject {
    void buyMac();
}

class OriginSubject implements Subject{

    public void buyMac() {
        System.out.println("本人买Mac");
    }
}

public class Proxy implements Subject {
    public void buyMac() {
        OriginSubject originSubject = new OriginSubject();
        originSubject.buyMac();
        this.wrap();
    }

    private void wrap() {
        System.out.println("包装好");
    }

    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.buyMac();
    }
}
