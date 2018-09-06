package com.chinawyny.algorithm.tree;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> dataStack = new Stack<>();

    private Stack<Integer> helpStack = new Stack<>();

    private int min = Integer.MAX_VALUE;

    public int min() {
        return min;
    }

    public void push(int x) {

        dataStack.push(x);
        if (x < min) {
            min = x;
            helpStack.push(x);
        } else {
            helpStack.push(min);
        }

    }

    public int pop() {
        helpStack.pop();
        min = helpStack.peek();
        return dataStack.pop();
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.min());
        System.out.println(minStack.pop());

    }

}
