package com.epam.classes;

import com.epam.Main;

import java.util.LinkedList;
import java.util.List;

/**
 * Class Chapter can contain any com.epam.classes, that implements TextObject except for Text and Chapter
 * Only this class contains name(chapterName) and content(paragraphs)
 */

public class Chapter implements TextObject {

    //list to store chapter content
    List<Paragraph> paragraphs = new LinkedList<Paragraph>();

    //list to store chapter name
    List<TextObject> chapterName = new LinkedList<TextObject>();

    public void print() {
        System.out.println();
        System.out.println();
        System.out.print("§ ");

        //loop to display chapter name
        for (TextObject object : chapterName) {
            object.print();
        }

        //loop to display chapter content
        for (Paragraph paragraph : paragraphs) {
            paragraph.print();
        }

    }

    public void addChildElement(TextObject object) {

        //chapter doesn't contain any high-order classes ant itself
        if (object instanceof Paragraph) {

            paragraphs.add((Paragraph) object);
        } else {

            Main.LOGGER.warn("Class "+object.getClass()+" isn't child to this");
        }
    }

    public List<TextObject> getElementsByClass(Class class4Search) {
        List<TextObject> elements = new LinkedList<TextObject>();

        //Is the Chapter required class?
        if (class4Search.isInstance(this)) {

            //add to list
            elements.add(this);
        } else {
            //search in paragraphs
            for (TextObject object : paragraphs) {
                elements.addAll(object.getElementsByClass(class4Search));
            }

            //search in chapter name
            for (TextObject object : chapterName) {
                elements.addAll(object.getElementsByClass(class4Search));
            }
        }

        return elements;
    }

    public List<TextObject> getChapterName() {
        return this.chapterName;
    }

    //As Chapter is one of the classes, that have name and content it is impossible add signature to interface
    public void setChapterName(TextObject object) {
        if(object instanceof Sentence || object instanceof Word || object instanceof Punctuation){
            this.chapterName.add(object);
        }else{
            Main.LOGGER.warn("Chapter name doesn't contain "+object.getClass()+" type of text");
        }

    }

    public List<Paragraph> getParagraphs(){
        return paragraphs;
    }
}
