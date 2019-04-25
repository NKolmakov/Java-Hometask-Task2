package classes;

import interfaces.TextObject;

import java.util.LinkedList;
import java.util.List;

/**
 * class Word contains only set of symbols
 */

public class Word implements TextObject {

    List<Symbol> symbols = new LinkedList<Symbol>();

    public void print() {

    }

    public void addChildElement(TextObject object) {
        if(object instanceof Symbol){
            symbols.add((Symbol)object);
        }else{
            System.out.println("");
        }
    }
}
