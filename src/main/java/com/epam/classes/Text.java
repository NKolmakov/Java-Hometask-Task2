package com.epam.classes;

import java.util.LinkedList;
import java.util.List;

/**
 * Class Text is the common class. It can include all types of text objects
 */

public class Text implements TextObject {
    List<TextObject> textObjects = new LinkedList<TextObject>();

    public void print() {
        for(TextObject textObject:textObjects){
            textObject.print();
        }
    }

    public void addChildElement(TextObject object) {
        textObjects.add(object);
    }
}
