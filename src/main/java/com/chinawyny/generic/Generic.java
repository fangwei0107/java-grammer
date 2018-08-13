package com.chinawyny.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Generic {

    public <T> T getParam(){
        return null;
    }

    public static<E> void rtti(List<E> list) {
        if (list instanceof LinkedList<?>){  // 编译错误
            // ...
        }
    }

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        ArrayList<Integer> ln = (ArrayList<Integer>) li;
        Object [] strings= new String[2];
        strings[0] ="hi";   // 插入正常
//        strings[1] =100;    //报错，因为100不是String类型
    }
}
