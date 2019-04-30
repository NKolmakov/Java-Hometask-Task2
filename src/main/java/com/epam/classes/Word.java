package com.epam.classes;

import java.util.LinkedList;
import java.util.List;

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
        System.out.print(this.word);
    }

    public void addChildElement(TextObject object) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Class "+this.getClass()+" is not a container. To add value use setWord() method or constructor");
    }

    public List<TextObject> getElementsByClass(Class class4Search) {
        List<TextObject> words = new LinkedList<TextObject>();

        if(class4Search.isInstance(this)){
            words.add(this);
        }

        return words;
    }

    public void setWord(String word){
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
}
