package com.chinawyny.designpattern.builder;

public class ConcreteBuilder extends Builder {

    Computer computer = new Computer();

    public void buildCPU() {
        computer.add("组装CPU");
    }

    public void buildMainboard() {
        computer.add("组装主板");
    }

    public void buildHD() {
        computer.add("组装HD");
    }

    public Computer getComputer() {
        return computer;
    }
}
