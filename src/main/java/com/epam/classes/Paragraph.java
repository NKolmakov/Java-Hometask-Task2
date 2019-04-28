package com.epam.classes;

import java.util.LinkedList;
import java.util.List;

public class Paragraph implements TextObject {
    /**
     * class Paragraph contains sentences, because any set of words can be a sentence
     * this class doesn't contain any other type of text objects
     */
   List<Sentence> sentences = new LinkedList<Sentence>();

    public void print() {
        for(Sentence sentence:sentences){
            sentence.print();
        }
    }

    public void addChildElement(TextObject object) {
        if (object instanceof Sentence) {
            sentences.add((Sentence) object);
        }else{
            System.out.println("This class contains only sentences");
        }
    }
}
