package com.chinawyny.designpattern.factory;

public class FactoryA extends Factory {
    public Product manufactureContainer() {
        return new ContainerProductA();
    }

    public Product manufactureMould() {
        return new MouldProductA();
    }
}

//B厂 - 生产模具+容器产品
class FactoryB extends Factory {

    public Product manufactureContainer() {
        return new ContainerProductB();
    }


    public Product manufactureMould() {
        return new MouldProductB();
    }

}