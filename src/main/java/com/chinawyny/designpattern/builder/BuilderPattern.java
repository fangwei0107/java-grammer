package com.chinawyny.designpattern.builder;

public class BuilderPattern {

    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        director.construct(builder);
        Computer computer = builder.getComputer();
        computer.show();
    }


}
