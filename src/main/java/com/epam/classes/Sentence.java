package com.epam.classes;

import com.epam.Main;

import java.util.LinkedList;
import java.util.List;

public class Sentence implements TextObject {
    List<Word> words = new LinkedList<Word>();
    List<Punctuation> punctuations = new LinkedList<Punctuation>();

    public void print() {
        for (int i = 0; i < words.size(); i++) {
            words.get(i).print();
            if (i < punctuations.size()) {
                punctuations.get(i).print();
            }
        }
    }

    public void addChildElement(TextObject object) {
        if (object instanceof Word) {
            this.words.add((Word) object);
        } else if (object instanceof Punctuation) {
            this.punctuations.add((Punctuation) object);
        } else {
            Main.LOGGER.warn("Class "+object.getClass()+" isn't child to this");
        }
    }

    public List<TextObject> getElementsByClass(Class class4Search) {
        List<TextObject> elements = new LinkedList<TextObject>();

        if (class4Search.isInstance(this)) {
            elements.add(this);
        } else {

            for (TextObject object : words) {
                elements.addAll(object.getElementsByClass(class4Search));
            }

            for (TextObject object : punctuations) {
                elements.addAll(object.getElementsByClass(class4Search));
            }
        }

        return elements;
    }

    public List<Word> getWords() {
        return words;
    }

    public List<Punctuation> getPunctuations(){
        return punctuations;
    }

}
