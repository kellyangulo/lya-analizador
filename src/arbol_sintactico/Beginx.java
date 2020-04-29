package arbol_sintactico;

import java.util.ArrayList;

public class Beginx implements Sx {
    ArrayList<Sx> sentences = new ArrayList<Sx>();

    public Beginx(ArrayList<Sx> sentences){
        this.sentences = sentences;
    }
}
