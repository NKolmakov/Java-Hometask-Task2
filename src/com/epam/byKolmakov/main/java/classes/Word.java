package classes;

import interfaces.TextObject;

/**
 * class Word contains only set of symbols
 */

public class Word implements TextObject {
    String word;

    public Word(){
        this.word = "";
    }

    public Word(String word){
        this.word = word;
    }
    public void print() {

    }

    public void addChildElement(TextObject object) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Class "+this.getClass()+" is not a container. To add value use setWord() method");
    }

    public void setWord(String word){
        this.word = word;
    }
}
