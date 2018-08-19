package com.chinawyny.reflectdemo;

public class RealObject implements Interface {
    @Override
    public void getMyName() {
        System.out.println("my name is huhx");
    }

    @Override
    public String getNameById(String id) {
        System.out.println("argument id: " + id);
        return "huhx";
    }
}
