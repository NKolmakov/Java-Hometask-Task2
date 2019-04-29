package com.epam.classes;

import java.util.LinkedList;
import java.util.List;

public class Paragraph implements TextObject {
    /**
     * class Paragraph contains sentences, because any set of words can be a sentence
     * this class doesn't contain any other type of text objects
     */
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
            System.out.println("This class contains only sentences");
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

}
