package com.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scanner {

    public static void main (String[] args){
        String input = "if kelly";
        ArrayList<Token> tokens = lex(input);
        for(Token token : tokens){
            System.out.println("(" + token.getTipo() + ": " + token.getValor() + ")");
        }
    }

    private static ArrayList<Token> lex (String input){
        final ArrayList<Token> tokens = new ArrayList<Token>();
        final StringTokenizer st = new StringTokenizer(input);
        while(st.hasMoreTokens()) {
            String palabra = st.nextToken();
            boolean matched = false;

            for (Token.Tipos tokenTipo : Token.Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(palabra);
                if(matcher.find()) {
                    Token tk = new Token();
                    tk.setTipo(tokenTipo);
                    tk.setValor(palabra);
                    tokens.add(tk);
                    matched = true;
                }
            }

            if (!matched) {
                throw new RuntimeException("Se encontró un token invalido.");
            }
        }

        return tokens;
    }
}

    /*public static Stack <String> ScannerMamalon (String archivo) throws FileNotFoundException, IOException {
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

     */
