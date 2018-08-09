package com.chinawyny.algorithm;

public class AlgorithmTest {

    public static void main(String[] args) {
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        System.out.println(reversePolishNotation.evalRPN(new String[] {"2","1","+"}));
    }

}
