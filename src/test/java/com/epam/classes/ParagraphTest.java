package com.epam.classes;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ParagraphTest {

    Text text;
    Paragraph paragraph;
    List<Chapter> chapters = new LinkedList<Chapter>();
    List<Paragraph> paragraphs = new LinkedList<Paragraph>();
    List<Sentence> sentences = new LinkedList<Sentence>();
    List<Punctuation> punctuations = new LinkedList<Punctuation>();
    List<Word> words = new LinkedList<Word>();

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 30; i++) {
            chapters.add(new Chapter());
            paragraphs.add(new Paragraph());
            sentences.add(new Sentence());
            punctuations.add(new Punctuation());
            words.add(new Word());
        }
        text = new Text();
        paragraph = new Paragraph();
    }

    @Test
    public void addChildElementNotAddedAllElements() {
        List<TextObject> objects = new LinkedList<TextObject>();
        for (int i = 0; i < 30; i++) {
            objects.add(chapters.get(i));
            objects.add(paragraphs.get(i));
            objects.add(sentences.get(i));
            objects.add(punctuations.get(i));
            objects.add(words.get(i));

            paragraph.addChildElement(chapters.get(i));
            paragraph.addChildElement(paragraphs.get(i));
            paragraph.addChildElement(sentences.get(i));
            paragraph.addChildElement(punctuations.get(i));
            paragraph.addChildElement(words.get(i));
        }

        assertNotEquals(objects,paragraph.getSentences());
    }


    @Test
    public void addChildElementSuccessful() {
        List<TextObject> objects = new LinkedList<TextObject>();
        for (int i = 0; i < 30; i++) {
            objects.add(sentences.get(i));

            paragraph.addChildElement(chapters.get(i));
            paragraph.addChildElement(paragraphs.get(i));
            paragraph.addChildElement(sentences.get(i));
            paragraph.addChildElement(punctuations.get(i));
            paragraph.addChildElement(words.get(i));
        }

        assertEquals(objects,paragraph.getSentences());
    }

    @Test
    public void getElementsByClassHasClass() {
        List<TextObject> objects = new LinkedList<TextObject>();

        for (int i = 0; i < 30; i++) {
            objects.add(sentences.get(i));
            paragraph.addChildElement(sentences.get(i));
        }

        assertEquals(objects,paragraph.getElementsByClass(Sentence.class));
    }

    @Test
    public void getElementsByClassHasNotClass() {
        List<TextObject> objects = new LinkedList<TextObject>();
        List<Chapter> chapterList = new LinkedList<Chapter>();

        for (int i = 0; i < 30; i++) {
            paragraph.addChildElement(sentences.get(i));
        }

        assertEquals(chapterList,paragraph.getElementsByClass(Chapter.class));
    }

    @Test
    public void getSentences() {
        for (int i = 0; i < 30; i++) {
            paragraph.addChildElement(sentences.get(i));
        }

        assertEquals(sentences,paragraph.getSentences());
    }
}