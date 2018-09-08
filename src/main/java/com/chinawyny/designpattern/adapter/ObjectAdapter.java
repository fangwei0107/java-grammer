package com.chinawyny.designpattern.adapter;


//被适配者
class Adaptee {
    void playMp3(Object src) {
        System.out.println("播放MP3：" + src);
    }
}

//目标，也就是用户所希望使用的，与被适配者无关系
interface Target {
    void playFlac(Object src);
}

/**
 * 对象适配器
 * <p>
 * 使用地方：一个程序想使用已经存在的类，但是该类所实现的接口和当前程序所使用的接口不一致时。
 * <p>
 * 优点：1. 目标与被适配者解耦；2. 满足开-闭原则
 */
public class ObjectAdapter implements Target {
    private Adaptee adaptee;
    
    public ObjectAdapter() {
        super();
        adaptee = new Adaptee();
    }
    
    @Override
    public void playFlac(Object src) {
        //可能需要对src作处理
        adaptee.playMp3(src);
    }
}
