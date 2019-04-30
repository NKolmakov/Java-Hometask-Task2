package com.epam.classes;

import com.epam.Main;

import java.util.LinkedList;
import java.util.List;

/**
 * class Paragraph contains only sentences, because any set of words can be a sentence
 * this class doesn't contain any other type of text objects
 */

public class Paragraph implements TextObject {
    List<TextObject> sentences = new LinkedList<TextObject>();

    public void print() {
        System.out.println();
        for (TextObject sentence : sentences) {
            sentence.print();
        }
    }

    public void addChildElement(TextObject object) {
        if (object instanceof Sentence) {
            sentences.add((Sentence) object);
        } else {
            Main.LOGGER.warn("Class "+object.getClass()+" isn't child to this");
        }
    }

    public List<TextObject> getElementsByClass(Class class4Search) {
        List<TextObject> elements = new LinkedList<TextObject>();

        if (class4Search.isInstance(this)) {
            elements.add(this);
        } else {

            for (TextObject object : sentences) {
                elements.addAll(object.getElementsByClass(class4Search));
            }

        }

        return elements;
    }

    public List<TextObject> getSentences(){
        return sentences;
    }

}
