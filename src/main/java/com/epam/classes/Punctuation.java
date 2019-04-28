package com.epam.classes;

public class Punctuation implements TextObject {
    private String punctuation = "";

    public Punctuation(){

    }

    public Punctuation(String punctuation){
        this.punctuation = punctuation;
    }

    public void print() {
        System.out.print(punctuation);
    }


    public void addChildElement(TextObject object) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Class Symbol is non-container class! Call setPunctuation() method or constructor to set a value");
    }

    public void setPunctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    public String getPunctuation() {
        return this.punctuation;
    }

    @Override
    public String toString() {
        return punctuation;
    }
}
