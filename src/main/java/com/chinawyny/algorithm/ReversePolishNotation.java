package com.chinawyny.algorithm;

import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> intStack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")
                || tokens[i].equals("-")
                || tokens[i].equals("*")
                || tokens[i].equals("/")) {
                int b = intStack.pop();
                int a = intStack.pop();
                intStack.push(Cal(tokens[i], a, b));
            }else {
                intStack.push(Integer.parseInt(tokens[i]));
            }
        }
        return intStack.pop();
    }

    private Integer Cal(String s, int a, int b) {

        if(s.equals("+")){
            return a+b;
        }
        else if(s.equals("-")){
            return a-b;
        }
        else if(s.equals("*")){
            return a*b;
        }
        else
            return a/b;
    }

}
