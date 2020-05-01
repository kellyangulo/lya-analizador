package analizador;

import arbol_sintactico.*;


import java.util.ArrayList;

public class Semantico {
    Printx print;
    Beginx begin;
    Ifx ifx;
    Programa programa;
    ComparaNum comparaNum;
    ArrayList<String> variables, noExisten;
    ComparaId comparaId;
    Programa p;

    public Semantico(Programa programa){
        this.programa = programa;
        variables = new ArrayList<String>();
        noExisten = new ArrayList<String>();

        for (int i = 0; i < programa.d.size(); i++){
            String temp2 = programa.d.get(i).id;
            for (int j = programa.d.size()-1; j >= 0; j--) {
                if(i != j && temp2.equals(programa.d.get(j).id)) {
                    System.out.println("** " + temp2 + Help.whiteSpaces(temp2.length()) + "//La variable es repetida:c//" );
                    programa.d.remove(j);
                }
            }
        }
        //Todas las variables que se utilizan en la setencias
        for (int i = 0; i < programa.s.size(); i++)
        {
            if(programa.s.get(i) instanceof Ifx){
                ifx = (Ifx) programa.s.get(i);
                Instancias(i, ifx.e);
            }
            if(programa.s.get(i) instanceof Printx) {
                print = (Printx) programa.s.get(i);
                Instancias(i, print.e);
            }
        }

        for (int i = 0; i < variables.size(); i++){
            for (int j = variables.size()-1; j >= 0 ; j--){
                if(i != j)
                    if(variables.get(i).equals(variables.get(j)))
                        variables.remove(j);
            }
        }
        int cont = 0;
        String temp = "";
        for (int i = 0; i < variables.size(); i++){
            cont = 0;
            for (int j = 0; j < p.d.size(); j++) {
                temp = p.d.get(j).id;
                if(!variables.get(i).equals(temp)){
                    cont++;
                }
            }
            if(cont == p.d.size())
            {
                noExisten.add(variables.get(i));
                System.out.println( "** " + variables.get(i) +  Help.whiteSpaces(variables.get(i).length()) +"** Variable NO declarada anteriormente.");
            }
        }


    }
    //Agarra todos los id (variables) sin importar si está definida.
    public void Instancias(int i, Object obj){
        try {
            if(obj == ifx.e && obj instanceof ComparaId){
                comparaId = (ComparaId) obj;
                variables.add(((Idx)comparaId.id1).id1);
                variables.add(((Idx)comparaId.id2).id1);
            }
        } catch (Exception e) {}
        try {
            if(obj == print.e && obj instanceof ComparaId)
            {
                comparaId = (ComparaId) obj;
                variables.add(((Idx)comparaId.id1).id1);
                variables.add(((Idx)comparaId.id2).id1);
            }
        } catch (Exception e) {}
    }
}
