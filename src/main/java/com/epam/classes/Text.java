package com.epam.classes;

import java.util.LinkedList;
import java.util.List;

/**
 * Class Text is the common class. It can include all types of text objects
 */

public class Text implements TextObject {
    List<TextObject> textObjects = new LinkedList<TextObject>();

    public void print() {
        for (TextObject textObject : textObjects) {
            textObject.print();
        }
    }

    public void addChildElement(TextObject object) {
        textObjects.add(object);
    }

    public List<TextObject> getElementsByClass(Class class4Search) {
        List<TextObject> elements = new LinkedList<TextObject>();

        for(TextObject object: textObjects){
            elements.addAll(object.getElementsByClass(class4Search));
        }

        return elements;
    }

    public List<TextObject> getTextObjects(){
        return textObjects;
    }
}
