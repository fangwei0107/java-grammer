package com.chinawyny.designpattern.strategy;

abstract class Strategy {
    public abstract void show();
}

class StrategyA extends Strategy {

    public void show() {
        System.out.println("活动A");
    }
}

class StrategyB extends Strategy {
    public void show() {
        System.out.println("活动B");
    }
}


public class StrategyPattern {

    Strategy strategy;

    public StrategyPattern(String festival) {
        switch (festival) {
            case "a":
                strategy = new StrategyA();
                break;
            case "b":
                strategy = new StrategyB();
                break;
            default:
                strategy = null;
        }
    }

    public static void main(String[] args) {
        StrategyPattern strategyPattern = new StrategyPattern("a");
        strategyPattern.strategy.show();
    }

}
