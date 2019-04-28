package com.epam.classes;

import java.util.LinkedList;
import java.util.List;

public class Sentence implements TextObject {
    List<Word> words = new LinkedList<Word>();

    public void addWord(Word word){
        this.words.add(word);
    }

    public void print() {
        for(Word word:words){
            word.print();
        }
    }

    public void addChildElement(TextObject object) {
        if(object instanceof Word){
            this.words.add((Word)object);
        }else{
            System.out.println("Class "+object.getClass()+"can't be in sentence");
        }
    }
}
