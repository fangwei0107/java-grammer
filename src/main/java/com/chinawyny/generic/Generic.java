package com.chinawyny.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generic<T, U> {

    public <T> List<T> getParam(){
        return new ArrayList<T>();
    }

    public static void main(String[] args) {
        List<String> aList = Arrays.asList("111","222");
        List<? extends Object> covariantList = aList;
        List<? super String> contravariantList = aList;
//        covariantList.add("d"); //wrong
        Object a = covariantList.get(0);
        System.out.println(a);
        contravariantList.add(1, "d"); //OK
//        String b = contravariantList.get(1); //wrong
        Object c = contravariantList.get(1);}
}
class Super {
    void getSomething(String str){
        System.out.println("2");
    }
}
class Sub extends Super {

    void getSomething(Object str) {
        System.out.println(str);
    }
}