package com.chinawyny.designpattern.face;

// 使用很简单，用户无需关系内部是如何操作了，只需要使用这个购买接口即可：
public class TestUse {
    public static void main(String args[]) {
        Object info = ProductSalesman.instance.buySomething("银河飞船", "地球", "K1234523");
        System.out.println(info);
    }
}
