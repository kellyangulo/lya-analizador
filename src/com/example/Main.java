package com.example;

import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Stack <String> pila = Scanner.ScannerMamalon("archivo.txt");
        System.out.println(pila.size());

    }
}
