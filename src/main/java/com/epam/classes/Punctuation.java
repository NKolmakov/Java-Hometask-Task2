package com.epam.classes;

import com.epam.Main;

import java.util.LinkedList;
import java.util.List;

/**
 * This is simple type of text. Class punctuation contains one string field
 * It can't be container, so it can't implements methods to return a set of elements
 */
public class Punctuation implements TextObject {
    private String punctuation = "";

    public Punctuation() {

    }

    public Punctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    public void print() {
        System.out.print(punctuation);
    }


    public void addChildElement(TextObject object) throws UnsupportedOperationException {
        Main.LOGGER.error("Called unsupported method.");
        throw new UnsupportedOperationException("Class Symbol isn't container! Use constructor to set a value");
    }

    public List<TextObject> getElementsByClass(Class class4Search) {
        List<TextObject> punctuations = new LinkedList<TextObject>();

        if (class4Search.isInstance(this)) {
            punctuations.add(this);
        }

        return punctuations;
    }

    public void setPunctuation(String punctuation){
        this.punctuation = punctuation;
    }

    public String getPunctuation(){
        return punctuation;
    }
}
