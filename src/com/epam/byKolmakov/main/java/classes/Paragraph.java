package classes;

import interfaces.TextObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Paragraph implements TextObject {
    List<Subparagraph> subparagraphs = new LinkedList<Subparagraph>();

    public void addSubparagraph(Subparagraph subparagraph){
        this.subparagraphs.add(subparagraph);
    }

    public void print() {

    }
}
