package classes;

import interfaces.TextObject;

public class Symbol implements TextObject {
   private char symbol = ' ';
    public void print() {

    }

    public void addChildElement(TextObject object) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Class Symbol is non-container class! Call setSymbol() method to set a value");
    }

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }
    public Character getValue(){
        return Character.valueOf(symbol);
    }
}
