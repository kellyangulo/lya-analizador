package com.example;

import java.util.ArrayList;
import com.example.Token.Tipos;

public class Parser {

    ArrayList<Token> tokens;
    int tokenActual;
    Token tok;

    public Parser(ArrayList<Token> tokens){
        this.tokens = tokens;
        this.tokenActual = 0;
        this.tok = tokens.get(this.tokenActual);
    }

    public void advance(){
        this.tokenActual ++;
        this.tok = this.tokens.get(this.tokenActual);
    }

    public void eat(Tipos t){
        if(this.tok.getTipo() == t)
            advance();
        else
            error();
    }

    public void S(){
        switch (this.tok.getTipo()){
            case IF:
                eat(Tipos.IF);
                E();
                eat(Tipos.THEN);
                S();
                eat(Tipos.ELSE);
                S();
                break;
            case BEGIN:
                eat(Tipos.BEGIN);
                S();
                L();
                break;
            case PRINT:
                eat(Tipos.PRINT);
                E();
                break;
            default:
                error();
        }
    }

    public void L(){
        switch (this.tok.getTipo()){
            case END:
                eat(Tipos.END);
                break;
            case semi:
                eat(Tipos.semi);
                S();
                L();
                break;
            default:
                error();
        }
    }

    public void E(){
        eat(Tipos.num);
        eat(Tipos.EQU);
        eat(Tipos.num);
    }

    public void error(){
        System.out.println("Error");
    }
}
