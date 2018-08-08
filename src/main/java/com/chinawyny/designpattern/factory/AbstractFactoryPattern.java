package com.chinawyny.designpattern.factory;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        Factory factoryB = new FactoryB();
        factoryA.manufactureContainer().Show();
        factoryA.manufactureMould().Show();
        factoryB.manufactureContainer().Show();
        factoryB.manufactureMould().Show();
    }
}
