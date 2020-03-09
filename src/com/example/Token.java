package com.example;

public class Token {

    //Propiedades
    public Tipos getTipo(){
        return tipo;
    }
    public void setTipo(Tipos tipo){
        this.tipo = tipo;
    }
    public String getValor(){
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }

    private Tipos tipo;
    private String valor;

    //Clasificación de los valores que entrarán
    public enum Tipos {
        //Palabras reservadas del lenguaje
        IF ("^if$"),
        THEN("^then$"),
        ELSE("^else$"),
        BEGIN("^begin$"),
        END("^end$"),
        PRINT("^print$"),
        EQU("^=$"),
        semi("^[;]$"), //Semicolon
        num("^[+]?([0-9])+$"); //Solo se aceptan números positivos enteros

        public final String patron;
        Tipos(String s){
            this.patron = s;
        }
    }

}
