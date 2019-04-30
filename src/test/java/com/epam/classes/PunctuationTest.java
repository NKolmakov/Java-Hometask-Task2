package com.epam.classes;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class PunctuationTest {

    Text text;
    Paragraph paragraph;
    Punctuation punctuation;

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
        punctuation = new Punctuation();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addChildElement() {
        punctuation.addChildElement(paragraphs.get(0));
    }

    @Test
    public void getElementsByClassTrue() {
        List<Punctuation> punctuationList = new LinkedList<Punctuation>();
        punctuationList.add(punctuation);

        assertEquals(punctuationList,punctuation.getElementsByClass(Punctuation.class));
    }

    @Test
    public void setPunctuation() {
    }

    @Test
    public void getPunctuation() {
    }
}