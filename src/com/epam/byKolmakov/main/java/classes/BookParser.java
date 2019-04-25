package classes;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookParser {
    private static BookParser instance;

    private final String REGEX_PUNCTUATION = "\\. +| +|\\., +|\\.\\r\\n *|[\\.,\\?!;]";
    private final String REGEX_WORD = "\\w+";
    private final String REGEX_SENTENCE = "\\. |\\.$|\\?\\!|[\\?!]|\\.{3}";
    private final String REGEX_CHAPTER = "§ +\\d*\\w+ \\r\\n";
    private final String REGEX_PARAGRAPH = "";
    private final String REGEX_SYMBOL = "";

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
        fillAllLists(textFromBook);
    }

    private void fillAllLists(String textFromBook) {
        fillList(chapters, textFromBook.split(REGEX_CHAPTER));
        fillList(paragraphs, textFromBook.split(REGEX_PARAGRAPH));
        fillList(sentences, textFromBook.split(REGEX_SENTENCE));
        fillList(words, textFromBook.split(REGEX_WORD));
        fillList(punctuations, textFromBook.split(REGEX_PUNCTUATION));
        fillList(symbols, textFromBook.split(REGEX_SYMBOL));
    }

    private void fillList(List list, String[] strings) {
        for (String string : strings) {
            list.add(string);
        }
    }

}
