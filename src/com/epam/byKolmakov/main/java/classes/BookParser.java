package classes;

import interfaces.TextObject;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookParser {
    private static BookParser instance;

    private final String REGEX_PUNCTUATION = "\\. +| +|\\., +|\\.\\r\\n *|[\\.,\\?!;]";
    private final String REGEX_WORD = "[А-яA-z0-9]+";
    private final String REGEX_SENTENCE = "([^.!?\\n]+[.!?])";
    private final String REGEX_CHAPTER = "§.+([.]++[^§]*)+";
    private final String REGEX_PARAGRAPH = "\n+.++";
    private final String REGEX_SYMBOL = ".";

    private List<String> chapters = new LinkedList<String>();
    private List<String> paragraphs = new LinkedList<String>();
    private List<String> sentences = new LinkedList<String>();
    private List<String> words = new LinkedList<String>();
    private List<String> symbols = new LinkedList<String>();
    private List<String> punctuations = new LinkedList<String>();

    private Text text = new Text();

    private BookParser() {
    }

    public static BookParser getInstance() {
        if (instance == null) {
            return new BookParser();
        }
        return instance;
    }

    public Text getText() {
        return text;
    }

    public void parseBook(Book book) {
        String textFromBook = book.getText();
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
        Text text1 = new Text();

        List<String> chapterList = separateBy(text, REGEX_CHAPTER);
        List<String> paragraphList = separateBy(text, REGEX_PARAGRAPH);
        List<String> sentenceList = separateBy(text, REGEX_SENTENCE);
        List<String> wordList = separateBy(text, REGEX_WORD);
        List<String> symbolList = separateBy(text, REGEX_SYMBOL);


        List<TextObject> chapters = parseChapters(text);
        List<TextObject> paragraphs = parseParagraphs(text);
        if (chapters.size() != 0) {
            for (TextObject chapter : chapters) {
                text1.addChildElement(chapter);
            }

        } else {
            if (paragraphs.size() != 0) {
                for (TextObject paragraph : paragraphs) {
                    text1.addChildElement(paragraph);
                }
            }
        }
    }

    private List<TextObject> parseChapters(String text) {
        List<TextObject> chapters = new LinkedList<TextObject>(); // list to store parsed chapters as Objects

        for (String chapter : text.split(REGEX_CHAPTER)) {
            Chapter chapter1 = new Chapter();
            for (TextObject paragraph : parseParagraphs(chapter)) {
                chapter1.addChildElement(paragraph);
            }
            chapters.add(chapter1);
        }

        return chapters;
    }

    private List<TextObject> parseParagraphs(String chapter) {
        List<TextObject> paragraphs = new LinkedList<TextObject>();

        for (String paragraph : chapter.split(REGEX_PARAGRAPH)) {
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

        for (String sentence : paragraph.split(REGEX_SENTENCE)) {
            Sentence sentence1 = new Sentence();

            for (TextObject word : parseWords(sentence)) {
                sentence1.addChildElement(word);
            }

            sentences.add(sentence1);
        }

        return sentences;
    }

    private List<TextObject> parseWords(String sentence) {
        List<TextObject> words = new LinkedList<TextObject>();

        for (String word : sentence.split(REGEX_WORD)) {
            Word word1 = new Word(word);
            words.add(word1);
        }

        return words;
    }

    private List<TextObject> parsePunctuation(String sentence) {
        List<TextObject> punctiations = new LinkedList<TextObject>();

        for (String punctuation : sentence.split(REGEX_PUNCTUATION)) {
            Punctuation punctuation1 = new Punctuation(punctuation);
            punctiations.add(punctuation1);
        }

        return punctiations;
    }
}

