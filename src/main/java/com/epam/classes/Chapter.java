package com.epam.classes;

import java.util.LinkedList;
import java.util.List;

/**
 * Class Chapter can contain any com.epam.classes except for Text and Chapter
 */

public class Chapter implements TextObject {
    List<Paragraph> paragraphs = new LinkedList<Paragraph>();
    String name = "";

    public void print() {
        System.out.println(name);
        for(Paragraph paragraph:paragraphs){
            paragraph.print();
        }
    }

    public void addChildElement(TextObject object) {
        if (object instanceof Paragraph) {
            paragraphs.add((Paragraph) object);
        } else {
            System.out.println("Class " + object.getClass() + " can't be in paragraph");
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
