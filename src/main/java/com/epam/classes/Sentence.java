package com.epam.classes;

import java.util.LinkedList;
import java.util.List;

public class Sentence implements TextObject {
    List<Word> words = new LinkedList<Word>();
    List<Punctuation> punctuations = new LinkedList<Punctuation>();

    public void print() {
        for (int i = 0; i < words.size(); i++) {
            words.get(i).print();
            punctuations.get(i).print();
        }
    }

    public void addChildElement(TextObject object) {
        if(object instanceof Word){
            this.words.add((Word)object);
        }else if(object instanceof Punctuation) {
            this.punctuations.add((Punctuation) object);
        }else{
            System.out.println("Class "+object.getClass()+"can't be in sentence");
        }
    }
}
