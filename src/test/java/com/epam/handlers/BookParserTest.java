package com.epam.handlers;

import com.epam.classes.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class BookParserTest {
    Text text;
    BookParser parser = BookParser.getInstance();
    List<Sentence> sentenceList;
    List<Paragraph> paragraphList;
    List<Chapter> chapterList;

    @Before
    public void setUp() {
        Sentence sentence = new Sentence();
        Paragraph paragraph = new Paragraph();
        Chapter chapter = new Chapter();

        text = new Text();
        sentenceList = new LinkedList<Sentence>();
        paragraphList = new LinkedList<Paragraph>();
        chapterList = new LinkedList<Chapter>();

        sentence.addChildElement(new Word("1"));
        sentence.addChildElement(new Punctuation(". "));
        sentence.addChildElement(new Word("Word"));
        sentence.addChildElement(new Punctuation("."));

        chapter.setChapterName(sentence);
        sentence = new Sentence();

        sentence.addChildElement(new Word("Text"));
        sentence.addChildElement(new Punctuation(" "));
        sentence.addChildElement(new Word("text"));
        sentence.addChildElement(new Punctuation(" "));
        sentence.addChildElement(new Word("text"));
        sentence.addChildElement(new Punctuation(". "));

        sentenceList.add(sentence);
        sentence = new Sentence();

        sentence.addChildElement(new Word("Text"));
        sentence.addChildElement(new Punctuation(" "));
        sentence.addChildElement(new Word("text"));
        sentence.addChildElement(new Punctuation("."));

        sentenceList.add(sentence);
        sentence = new Sentence();

        sentence.addChildElement(new Word("Text"));
        sentence.addChildElement(new Punctuation(" "));
        sentence.addChildElement(new Word("text"));
        sentence.addChildElement(new Punctuation(" "));
        sentence.addChildElement(new Word("text"));
        sentence.addChildElement(new Punctuation(". "));

        sentenceList.add(sentence);

        paragraph.addChildElement(sentenceList.get(0));
        paragraph.addChildElement(sentenceList.get(1));
        paragraphList.add(paragraph);

        paragraph = new Paragraph();
        paragraph.addChildElement(sentenceList.get(2));
        paragraphList.add(paragraph);

        chapter.addChildElement(paragraphList.get(0));
        chapter.addChildElement(paragraphList.get(1));

        text.addChildElement(chapter);
    }

    @Test
    public void getInstance() {
        BookParser bookParser2 = BookParser.getInstance();
        assertSame(parser, bookParser2);
    }

    @Test
    public void parseBook() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String expectedString = "§ 1. Word.\nText text text. Text text.\nText text text.";
        int inc = 0;

        parser.parseBook(new Book("src/test/resources/text4test"));
        Text testText = parser.getTextAsObject();

        for(TextObject chapter:testText.getElementsByClass(Chapter.class)) {
            stringBuilder.append("§ ");

            for(TextObject chapterName:((Chapter)chapter).getChapterName()){
                for(TextObject sentence:chapterName.getElementsByClass(Sentence.class)){
                    inc = 0;
                    for (TextObject word : sentence.getElementsByClass(Word.class)) {
                        stringBuilder.append(((Word) word).getWord());
                        stringBuilder.append(((Punctuation) sentence.getElementsByClass(Punctuation.class).get(inc++)).getPunctuation());
                    }
                }
            }
            for (TextObject paragraph : testText.getElementsByClass(Paragraph.class)) {
                stringBuilder.append("\n");
                for (TextObject sentence : paragraph.getElementsByClass(Sentence.class)) {
                    inc = 0;
                    for (TextObject word : sentence.getElementsByClass(Word.class)) {
                        stringBuilder.append(((Word) word).getWord());
                        stringBuilder.append(((Punctuation) sentence.getElementsByClass(Punctuation.class).get(inc++)).getPunctuation());
                    }
                }
            }
        }

        String actual = stringBuilder.toString();
        assertEquals(expectedString, actual);

    }
}