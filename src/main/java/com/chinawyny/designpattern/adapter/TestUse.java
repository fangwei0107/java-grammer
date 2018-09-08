package com.chinawyny.designpattern.adapter;

/**
 * 类适配器与对象适配器的区别就是类适配器需要继承被适配者
 *
 *  如果目标接口中的方法数与被适配器者中的数目相同，就是完全适配，
 *  若目标接口中的方法更多，则是剩余适配，反之，为不完全适配。
 */
public class TestUse {
    
    public static void main(String args[]) {
        
        Adaptee adaptee = new Adaptee();
        adaptee.playMp3("mp3");
        
        Target target = new ClassAdapter();
        target.playFlac("flac");
        target = new ObjectAdapter();
        target.playFlac("flac");
    }
    
}
