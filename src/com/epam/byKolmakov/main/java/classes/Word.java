package classes;

import interfaces.IHaveChildObject;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Word implements IHaveChildObject {

    private static final String REGEX_WORD = "\\w+"; //todo: don't foget about static fields!
    private static final String REGEX_SIGN = "\\. +| +|\\., +|\\.\\r\\n *|[\\.,\\?!;]";
    String text = new Symbol().getTextFileAsString().replaceAll(" +", " ");

    private List<String> words = new ArrayList<String>();
    private List<String> signs = new ArrayList<String>();

    public Word(){
        separateByWords();
        separateBySigns();
        new Sentence(this); //todo: if program will be broken problem is here
    }

    public List getChildClassObjects() {
        return words;
    }

    public List<String> getSigns() {
        return signs;
    }

    private void separateByWords() {
        Pattern wordPattern = Pattern.compile(REGEX_WORD);
        Matcher wordMatcher = wordPattern.matcher(text); //todo: temp code
        while (wordMatcher.find()) {
            String word = text.substring(wordMatcher.start(), wordMatcher.end());
            words.add(word);
        }
    }

    private void separateBySigns() {
        Pattern signPattern = Pattern.compile(REGEX_SIGN);
        Matcher signMatcher = signPattern.matcher(text); //todo: also temp code
        while (signMatcher.find()) {
            String sign = text.substring(signMatcher.start(), signMatcher.end());
            signs.add(sign);
        }
    }
}
