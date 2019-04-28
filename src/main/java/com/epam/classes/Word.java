package com.epam.classes;

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
        System.out.println(this.word);
    }

    public void addChildElement(TextObject object) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Class "+this.getClass()+" is not a container. To add value use setWord() method or constructor");
    }

    public void setWord(String word){
        this.word = word;
    }
}
