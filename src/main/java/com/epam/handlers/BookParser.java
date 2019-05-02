package com.epam.handlers;

import com.epam.classes.*;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookParser {
    private static BookParser instance;

    private final String REGEX_PUNCTUATION = "\\.{1,3}([, ])*| ?— ?|,? |-";
    private final String REGEX_WORD = "[А-яA-z0-9ё]+";
    private final String REGEX_SENTENCE = "([^.!?\\n]+[.!?] *)";
    private final String REGEX_CHAPTER = "§.+([.]++[^§]*)+";
    private final String REGEX_CHAPTER_NAME = "§.+[^\\n]";
    private final String REGEX_PARAGRAPH = "\n+.++";

    private Text textObject;

    private BookParser() {
    }

    public static BookParser getInstance() {
        if (instance == null) {
            instance = new BookParser();
            return instance;
        }
        return instance;
    }

    public Text getTextAsObject() {
        return textObject;
    }

    public void parseBook(Book book) {
        String textFromBook = book.getText().replaceAll(" {2,}", " ").replaceAll("\\n{2,}", "\\n");
        startParse(textFromBook);
    }

    private List<String> separateBy(String string, String regex) {
        List<String> elements = new LinkedList<String>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {

            elements.add(matcher.group());
        }

        return elements;
    }

    private void startParse(String text) {
        textObject = new Text();
        //checking text elements
        if (separateBy(text, REGEX_CHAPTER).size() != 0) {

            //text has chapters
            for (TextObject chapter : parseChapters(text)) {
                textObject.addChildElement(chapter);
            }

        } else {
            if (separateBy(text, REGEX_PARAGRAPH).size() != 0) {

                //text hasn't chapters and has paragraphs
                for (TextObject paragraph : parseParagraphs(text)) {
                    textObject.addChildElement(paragraph);
                }
            } else {

                //text has only sentences
                for (TextObject sentence : parseSentences(text)) {
                    textObject.addChildElement(sentence);
                }
            }
        }
    }

    private List<TextObject> parseChapters(String text) {
        List<TextObject> chapters = new LinkedList<TextObject>(); // list to store parsed chapters as Objects

        for (String chapter : separateBy(text, REGEX_CHAPTER)) {
            Chapter chapter1 = new Chapter();

            //loop for define chapter name
            for (TextObject object : parseChapterName(chapter, REGEX_CHAPTER_NAME)) {
                chapter1.setChapterName(object);
            }

            for (TextObject paragraph : parseParagraphs(chapter)) {
                chapter1.addChildElement(paragraph);
            }
            chapters.add(chapter1);
        }

        return chapters;
    }

    private List<TextObject> parseChapterName(String chapter, String regex) {
        List<TextObject> name = new LinkedList<TextObject>();
        String stringNameOfChapter = separateBy(chapter, regex).get(0).replaceAll("§ ", "");

        if (separateBy(stringNameOfChapter, REGEX_SENTENCE).size() != 0) {
            List<TextObject> sentences = new LinkedList<TextObject>();

            for (String sentence : separateBy(stringNameOfChapter, REGEX_SENTENCE)) {

                Sentence sentence1 = new Sentence();
                List<TextObject> words = new LinkedList<TextObject>();
                List<TextObject> punctuations = new LinkedList<TextObject>();

                for (TextObject word : parseWords(sentence)) {
                    words.add(word);
                }

                for (TextObject punctuation : parsePunctuation(sentence)) {
                    punctuations.add(punctuation);
                }

                for (int i = 0; i < words.size(); i++) {
                    if (i < punctuations.size()) {
                        sentence1.addChildElement(words.get(i));
                        sentence1.addChildElement(punctuations.get(i));
                    } else {
                        sentence1.addChildElement(words.get(i));
                    }
                }

                sentences.add(sentence1);
            }
            name.addAll(sentences);
        }

        return name;
    }

    private List<TextObject> parseParagraphs(String chapter) {
        List<TextObject> paragraphs = new LinkedList<TextObject>();

        for (String paragraph : separateBy(chapter, REGEX_PARAGRAPH)) {
            Paragraph paragraph1 = new Paragraph();
            for (TextObject sentence : parseSentences(paragraph)) {
                paragraph1.addChildElement(sentence);
            }
            paragraphs.add(paragraph1);
        }

        return paragraphs;
    }

    private List<TextObject> parseSentences(String paragraph) {
        List<TextObject> sentences = new LinkedList<TextObject>();

        for (String sentence : separateBy(paragraph, REGEX_SENTENCE)) {
            Sentence sentence1 = new Sentence();
            List<TextObject> words = new LinkedList<TextObject>();
            List<TextObject> punctuations = new LinkedList<TextObject>();

            for (TextObject word : parseWords(sentence)) {
                words.add(word);
            }

            for (TextObject punctuation : parsePunctuation(sentence)) {
                punctuations.add(punctuation);
            }

            for (int i = 0; i < words.size(); i++) {
                sentence1.addChildElement(words.get(i));
                if (i < punctuations.size()) {
                    sentence1.addChildElement(punctuations.get(i));
                }
            }
            sentences.add(sentence1);
        }

        return sentences;
    }

    private List<TextObject> parseWords(String sentence) {
        List<TextObject> words = new LinkedList<TextObject>();

        for (String word : separateBy(sentence, REGEX_WORD)) {
            Word word1 = new Word(word);
            words.add(word1);
        }

        return words;
    }

    private List<TextObject> parsePunctuation(String sentence) {
        List<TextObject> punctiations = new LinkedList<TextObject>();

        for (String punctuation : separateBy(sentence, REGEX_PUNCTUATION)) {
            Punctuation punctuation1 = new Punctuation(punctuation);
            punctiations.add(punctuation1);
        }

        return punctiations;
    }
}

