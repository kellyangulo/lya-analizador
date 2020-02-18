package com.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Scanner {

    public static Stack <String> ScannerMamalon  (String archivo) throws FileNotFoundException, IOException {
        String cadena;
        Stack <String> pila = new Stack <String>();
        StringTokenizer st;

        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            st = new StringTokenizer(cadena);
            while(st.hasMoreTokens()){
                pila.push(st.nextToken());
            }
        }
        b.close();
        return pila;
    }
}
