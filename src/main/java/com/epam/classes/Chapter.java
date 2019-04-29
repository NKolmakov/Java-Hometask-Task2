package com.epam.classes;

import java.util.LinkedList;
import java.util.List;

/**
 * Class Chapter can contain any com.epam.classes except for Text and Chapter
 */

public class Chapter implements TextObject {
    List<Paragraph> paragraphs = new LinkedList<Paragraph>();
    List<TextObject> chapterName = new LinkedList<TextObject>();

    public void print() {
        System.out.println();
        System.out.println();
        System.out.print("§ ");
        for(TextObject object:chapterName){
            System.out.print(object.toString());
        }
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

    public List<TextObject> getElementsByClass(Class class4Search) {
        List<TextObject> elements = new LinkedList<TextObject>();

        if(class4Search.isInstance(this)) {
            elements.add(this);
        }else {

            for(TextObject object:paragraphs){
                elements.addAll(object.getElementsByClass(class4Search));
            }

            for(TextObject object:chapterName){
                elements.addAll(object.getElementsByClass(class4Search));
            }
        }

        return elements;
    }

    public List<TextObject> getChapterName(){
        return this.chapterName;
    }

    public void setChapterName(TextObject object){
        this.chapterName.add(object);
    }

}
