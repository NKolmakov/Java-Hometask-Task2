package classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookParser {
    private static BookParser instance;
    private Book book;
    private final String REGEX_SIGN = "\\. +| +|\\., +|\\.\\r\\n *|[\\.,\\?!;]";
    private final String REGEX_WORD = "\\w+";
    private final String REGEX_SENTENCE = "\\. |\\.$|\\?\\!|[\\?!]";
    private final String REGEX_PARAGRAPH = "";

    private BookParser() {
        try {
            book = new Book("text.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static BookParser getInstance() {
        if (instance == null) {
            synchronized (BookParser.class) {
                if (instance == null) {
                    return new BookParser();
                }
            }
        }
        return instance;
    }

    public Book getBook() {
        return book;
    }

    public String getREGEX_SIGN() {
        return REGEX_SIGN;
    }

    public String getREGEX_WORD() {
        return getREGEX_WORD();
    }

    public void startParse() {

    }

    private Word parseWord(int pos) {
        String text = book.getText().substring(pos);
        Pattern pattern = Pattern.compile(REGEX_WORD);
        Matcher matcher = pattern.matcher(text);

        matcher.find();
        String singleWord = text.substring(matcher.start(), matcher.end())+parseSign(pos);

        Word word = new Word();
        word.setWord(singleWord);

        return word;
    }

    private String parseSign(int pos) {
        String text = book.getText().substring(pos);
        Pattern pattern = Pattern.compile(REGEX_SIGN);
        Matcher matcher = pattern.matcher(text);

        matcher.find();
        String sign = text.substring(matcher.start(), matcher.end());
        pos = matcher.end();

        return sign;
    }

    private Sentence parseSentence(int pos) {
        String text = book.getText().substring(pos);
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = pattern.matcher(text);

        matcher.find();
        matcher.g
        String sentence = text.substring(matcher.start(), matcher.end());
        pos = matcher.end();

        Sentence sentence1 = new Sentence();


        return sentence1;
    }

    private void parseSubparagraph() {

    }

    private Paragraph parseParagraph(){
        String text = book.getText();

    }
}
