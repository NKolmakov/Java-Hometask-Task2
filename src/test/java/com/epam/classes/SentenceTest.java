package com.epam.classes;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SentenceTest {

    Text text;
    Paragraph paragraph;
    Punctuation punctuation;
    Sentence sentence;

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
        sentence = new Sentence();
    }

    @Test
    public void addChildElementTrue() {
        List<TextObject> expected = new LinkedList<TextObject>();
        List<TextObject> actual = new LinkedList<TextObject>();

        expected.add(words.get(0));
        expected.add(punctuations.get(0));

        sentence.addChildElement(words.get(0));
        sentence.addChildElement(punctuations.get(0));
        sentence.addChildElement(sentences.get(0));

        actual.addAll(sentence.getWords());
        actual.addAll(sentence.getPunctuations());

        assertEquals(expected, actual);
    }

    @Test
    public void getElementsByClassHasClass() {
        List<TextObject> objects = new LinkedList<TextObject>();

        for (int i = 0; i < 30; i++) {
            objects.add(words.get(i));
            sentence.addChildElement(words.get(i));
        }

        assertEquals(objects, sentence.getElementsByClass(Word.class));
    }

    @Test
    public void getElementsByClassHasNotClass() {

        for (int i = 0; i < 30; i++) {
            sentence.addChildElement(words.get(i));
        }

        assertEquals(new LinkedList<TextObject>(), sentence.getElementsByClass(Punctuation.class));
    }

    @Test
    public void getWords() {
        for (int i = 0; i < 30; i++) {
            sentence.addChildElement(words.get(i));
        }

        assertEquals(words, sentence.getWords());
    }

    @Test
    public void getPunctuations() {
        for (int i = 0; i < 30; i++) {
            sentence.addChildElement(punctuations.get(i));
        }

        assertEquals(punctuations, sentence.getPunctuations());
    }
}