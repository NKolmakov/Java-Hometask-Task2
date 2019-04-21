package classes;

import interfaces.TextObject;

import java.util.LinkedList;
import java.util.List;

public class Text implements TextObject {
    List<Paragraph> paragraphs = new LinkedList<Paragraph>();

    public void addParagraph(Paragraph paragraph){
        this.paragraphs.add(paragraph);
    }

    public void print() {

    }
}
