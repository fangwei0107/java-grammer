package com.chinawyny.enumdemo;

public enum Color {
    RED("红灯", 1), GREEN("green", 2), BLANK("blank", 3), YELLOW("yellow", 4);

    private String innerName;

    private int index;

    // 默认是private的
    Color(String innerName, int index) {
        this.innerName = innerName;
        this.index = index;
    }

    public String getInnerName() {
        return innerName;
    }

    public void setInnerName(String innerName) {
        this.innerName = innerName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static void main(String[] args) {
        System.out.println(Color.valueOf("RED") == Color.RED);
    }
}
