package com.epam.classes;

import com.epam.Main;

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
        Main.LOGGER.error("Called unsupported method.");
        throw new UnsupportedOperationException("Class Word isn't container! Use constructor to set a value");
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

    public String getWord(){
        return word;
    }
}
