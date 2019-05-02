package com.epam.handlers;

import com.epam.classes.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookHelperTest {
    Text text;
    BookHelper bookHelper;
    List<Sentence> sentenceList;

    @Before
    public void setUp() throws Exception {
        text = new Text();
        bookHelper = BookHelper.getInstance();
        sentenceList = new LinkedList<Sentence>();
        Sentence sentence = new Sentence();

        sentence.addChildElement(new Word("Word1"));
        sentence.addChildElement(new Punctuation(" "));
        sentence.addChildElement(new Word("Word2"));
        sentence.addChildElement(new Punctuation(" "));
        sentence.addChildElement(new Word("Word3"));
        sentence.addChildElement(new Punctuation("."));

        sentenceList.add(sentence);
        sentence = new Sentence();

        sentence.addChildElement(new Word("Word1"));
        sentence.addChildElement(new Punctuation(" "));
        sentence.addChildElement(new Word("Word2"));
        sentence.addChildElement(new Punctuation("."));

        sentenceList.add(sentence);

        for (Sentence sentence1 : sentenceList) {
            text.addChildElement(sentence1);
        }
    }

    @Test
    public void getInstanceNotNull() {
        assertNotNull(BookHelper.getInstance());
    }

    @Test
    public void getInstanceSameInstance() {
        BookHelper instance1 = BookHelper.getInstance();
        BookHelper instance2 = BookHelper.getInstance();

        assertEquals(instance1, instance2);
    }

    @Test
    public void printSentenceByWordsAmount() {
        List<Sentence> expected = new LinkedList<Sentence>();
        List<Sentence> actual = new LinkedList<Sentence>();
        expected.add(sentenceList.get(1));
        expected.add(sentenceList.get(0));

       actual.addAll(bookHelper.sortSentencesByWordsAmount(text));

       assertEquals(expected,actual);

    }
}