package com.epam.classes;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TextTest {

    Text text;
    Chapter chapter;
    Paragraph paragraph;
    Punctuation punctuation;
    Sentence sentence;
    Word word;


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
        chapter = new Chapter();
        text = new Text();
        paragraph = new Paragraph();
        punctuation = new Punctuation();
        sentence = new Sentence();
        word = new Word();
    }

    @Test
    public void addChildElement() {
        List<TextObject> expected = new LinkedList<TextObject>();
        expected.add(chapters.get(0));
        expected.add(paragraphs.get(0));
        expected.add(sentences.get(0));
        expected.add(punctuations.get(0));
        expected.add(words.get(0));

        text.addChildElement(chapters.get(0));
        text.addChildElement(paragraphs.get(0));
        text.addChildElement(sentences.get(0));
        text.addChildElement(punctuations.get(0));
        text.addChildElement(words.get(0));

        assertEquals(expected,text.getTextObjects());
    }

    @Test
    public void getElementsByClass() {
        List<TextObject> expected = new LinkedList<TextObject>();
        sentence.addChildElement(word);
        sentence.addChildElement(punctuation);
        paragraph.addChildElement(sentence);
        chapter.addChildElement(paragraph);
        text.addChildElement(chapter);

        expected.add(sentence);

        assertEquals(expected,text.getElementsByClass(Sentence.class));
    }
}