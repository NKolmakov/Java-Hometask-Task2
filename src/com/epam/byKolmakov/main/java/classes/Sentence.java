package classes;

import interfaces.TextObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence implements TextObject {
    List<Word> words = new LinkedList<Word>();

    public void addWord(Word word){
        this.words.add(word);
    }

    public void print() {

    }
}
