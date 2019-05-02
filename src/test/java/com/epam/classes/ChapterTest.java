package com.epam.classes;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ChapterTest {

    Book book;
    Chapter chapter;
    Chapter chapter1;
    Paragraph paragraph;
    Text text;
    List<Paragraph> paragraphs = new LinkedList<Paragraph>();
    List<TextObject> textObjects = new LinkedList<TextObject>();

    @Before
    public void setUp() throws Exception {
        book = new Book("text.txt");
        chapter = new Chapter();
        paragraph = new Paragraph();
        text = new Text();

        paragraphs.add(new Paragraph());
        paragraphs.add(new Paragraph());
        paragraphs.add(new Paragraph());

        textObjects.add(new Text());
        textObjects.add(new Text());
        textObjects.add(new Text());
    }

    @Test
    public void addChildElementSuccessful() {
        List<Paragraph> paragraphList = new LinkedList<Paragraph>();
        Paragraph paragraph1 = new Paragraph();
        paragraphList.add(paragraph1);
        chapter.addChildElement(paragraph1);

        assertEquals(paragraphList,chapter.getParagraphs());
    }

    @Test
    public void addChildElementFail() {
        textObjects.add(text);
        chapter.addChildElement(text);

        assertNotEquals(textObjects,chapter.getParagraphs());
    }

    @Test
    public void getElementsByClassHasElements() {
        for(Paragraph paragraph:paragraphs){
            chapter.addChildElement(paragraph);
        }

        assertEquals(paragraphs,chapter.getElementsByClass(Paragraph.class));
    }

    @Test
    public void getElementsByClassNoSuchElements() {
        for(TextObject text:textObjects){
            chapter.addChildElement(text);
        }

        assertNotEquals(textObjects,chapter.getElementsByClass(Text.class));
    }

    @Test
    public void getChapterName() {
        text = new Text();
        chapter1 = new Chapter();
        paragraph = new Paragraph();
        Sentence sentence = new Sentence();
        Word word = new Word();
        Punctuation punctuation = new Punctuation();
        chapter.setChapterName(text);
        chapter.setChapterName(chapter1);
        chapter.setChapterName(paragraph);
        chapter.setChapterName(sentence);
        chapter.setChapterName(word);
        chapter.setChapterName(punctuation);

        List<TextObject> objects = new LinkedList<TextObject>();
        objects.add(sentence);
        objects.add(word);
        objects.add(punctuation);


        assertEquals(objects,chapter.getChapterName());
    }

    @Test
    public void getParagraphs() {
        for(Paragraph paragraph:paragraphs){
            chapter.addChildElement(paragraph);
        }

        assertEquals(paragraphs,chapter.getParagraphs());
    }
}