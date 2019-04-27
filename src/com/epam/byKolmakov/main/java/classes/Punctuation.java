package classes;

import interfaces.TextObject;

public class Punctuation implements TextObject {
    private String punctuation = "";

    public Punctuation(){

    }

    public Punctuation(String punctuation){
        this.punctuation = punctuation;
    }

    public void print() {

    }


    public void addChildElement(TextObject object) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Class Symbol is non-container class! Call setPunctuation() method to set a value");
    }

    public void setPunctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    public String getPunctuation() {
        return this.punctuation;
    }
}
