package com.epam.classes;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class WordTest {
    Word word;

    @Before
    public void setUp(){
        word = new Word();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addChildElement() {
        word.addChildElement(new Sentence());
    }

    @Test
    public void getElementsByClass() {
        List<Word> expected = new LinkedList<Word>();
        expected.add(word);
        assertEquals(expected,word.getElementsByClass(Word.class));
    }

    @Test
    public void setWord() {
        String stringWord = "Hello World!";
        word = new Word();
        word.setWord(stringWord);
        assertEquals(stringWord,word.getWord());
    }

   @Test
    public void testWordConstructor(){
       String stringWord = "Hello World!";
       word = new Word(stringWord);
       assertEquals(stringWord,word.getWord());
   }
}