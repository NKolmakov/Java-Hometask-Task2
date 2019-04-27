package classes;

import interfaces.TextObject;

import java.util.LinkedList;
import java.util.List;

public class Chapter implements TextObject {
    /**
     * class Chapter can contain any classes except for Text and Chapter
     */
    List<Paragraph> paragraphs = new LinkedList<Paragraph>();

    public void print() {

    }

    public void addChildElement(TextObject object) {
        if (object instanceof Paragraph) {
            paragraphs.add((Paragraph) object);
        } else {
            System.out.println("Class " + object.getClass() + " can't be in paragraph");
        }
    }

}
