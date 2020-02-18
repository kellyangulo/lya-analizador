package com.example;

import java.util.Stack;

public class Parser {
    final int IF = 1, THEN = 2, ELSE = 3, BEGIN = 4, END = 5, PRINT = 6, SEMI = 7, NUM = 8, EQ =9;

    Stack <String> tokens;

    public Parser(Stack<String> tokens){
        this.tokens = tokens;
    }

    public static void parseToken (Stack <String> tok){

    }
}
