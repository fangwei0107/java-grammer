package com.chinawyny.enumdemo;

public enum Signal {
    GREEN, YELLOW, RED;

    public static void main(String[] args) {
        Signal color = Signal.RED;
        switch (color) {
            case RED:
                System.out.println("红灯");
                break;
            case GREEN:
                System.out.println("绿灯");
                break;
            case YELLOW:
                System.out.println("黄灯");
        }
    }
}
