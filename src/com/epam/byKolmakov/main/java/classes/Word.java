package classes;

import interfaces.IHaveChildObject;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Word implements IHaveChildObject {
    BookHelper bookHelper = BookHelper.getInstance();
    private List<String> words = new ArrayList<String>();

    public Word(){
        separateByWords();
        new Sentence(this); //todo: if program will be broken problem is here
    }

    public List getChildClassObjects() {
        return words;
    }

    public void separateByWords() {
        Pattern wordPattern = Pattern.compile(bookHelper.getREGEX_WORD());
        Matcher wordMatcher = wordPattern.matcher(bookHelper.getBook().getText());
        while (wordMatcher.find()) {
            String word = bookHelper.getBook().getText().substring(wordMatcher.start(), wordMatcher.end());
            words.add(word);
        }
    }


}
