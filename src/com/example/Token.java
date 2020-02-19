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
    enum Tipos {
        reservada ("[if|then|else|begin|end|print]"),
        semicolon("[;]"),
        numero("[0-9]+");

        public final String patron;
        Tipos(String s) {
            this.patron = s;
        }
    }

}
