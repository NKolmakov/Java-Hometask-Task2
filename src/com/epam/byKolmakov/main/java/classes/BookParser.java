package classes;

import interfaces.TextObject;

import java.util.LinkedList;
import java.util.List;

public class BookParser {
    private static BookParser instance;

    private final String REGEX_PUNCTUATION = "\\. +| +|\\., +|\\.\\r\\n *|[\\.,\\?!;]";
    private final String REGEX_WORD = "\\w+";
    private final String REGEX_SENTENCE = "\\. |\\.$|\\?\\!|[\\?!]|\\.{3}";
    private final String REGEX_CHAPTER = "§ +\\d*\\w+ \\r\\n";
    private final String REGEX_PARAGRAPH = "";
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
        String textFromBook = book.getText().replaceAll(" +", " ");

    }

    private void startParse(String text){
        Text text1 = new Text();
        List<TextObject> chapters = parseChapters(text);
        List<TextObject> paragraphs = parseParagraphs(text);
        if(chapters.size() != 0){
            for(TextObject chapter: chapters){
                text1.addChildElement(chapter);
            }

        }else{
            if(paragraphs.size() != 0){
                for(TextObject paragraph:paragraphs){
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

        for (String paragraph: chapter.split(REGEX_PARAGRAPH)){
            Paragraph paragraph1 = new Paragraph();
            for(TextObject sentence: parseSentences(paragraph)){
                paragraph1.addChildElement(sentence);
            }
            paragraphs.add(paragraph1);
        }

        return paragraphs;
    }

    private List<TextObject> parseSentences(String paragraph) {
        List<TextObject> sentences = new LinkedList<TextObject>();

        for(String sentence: paragraph.split(REGEX_SENTENCE)){
            Sentence sentence1 = new Sentence();

            for(TextObject word:parseWords(sentence)){
                sentence1.addChildElement(word);
            }

            sentences.add(sentence1);
        }

        return sentences;
    }

    private List<TextObject> parseWords(String sentence) {
        List<TextObject> words = new LinkedList<TextObject>();

        for(String word:sentence.split(REGEX_WORD)){
            Word word1 = new Word(word);
            words.add(word1);
        }

        return words;
    }

    private List<TextObject> parsePunctuation(String sentence) {
        List<TextObject> punctiations = new LinkedList<TextObject>();

        for(String punctuation: sentence.split(REGEX_PUNCTUATION)){
            Punctuation punctuation1 = new Punctuation(punctuation);
            punctiations.add(punctuation1);
        }

        return punctiations;
    }
}

