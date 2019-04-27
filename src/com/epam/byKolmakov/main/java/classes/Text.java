package classes;

import interfaces.TextObject;

import java.util.LinkedList;
import java.util.List;

/**
 * List is the type of TextObject because class Text can contain any type of existing classes    *
 * if there are no Chapter class Text will be contain low level class Paragraph etc    *
 * in any case class Text will be contain at least one paragraph, if file not empty
 */

public class Text implements TextObject {
    List<TextObject> textObjects = new LinkedList<TextObject>();

    public void print() {

    }

    public void addChildElement(TextObject object) {
        textObjects.add(object);
    }
}
