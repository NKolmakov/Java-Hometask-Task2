package classes;

import interfaces.TextObject;

import java.util.LinkedList;
import java.util.List;

public class Chapter implements TextObject {
    /**
     * class Chapter can contain any classes except for Text and Chapter
     */
    List<TextObject> paragraphs = new LinkedList<TextObject>();

    public void print() {

    }

    public void addChildElement(TextObject object) {
        paragraphs.add(object);
    }

}
