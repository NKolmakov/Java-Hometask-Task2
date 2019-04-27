package classes;

import interfaces.TextObject;

import java.util.LinkedList;
import java.util.List;

public class Sentence implements TextObject {
    List<Word> words = new LinkedList<Word>();

    public void addWord(Word word){
        this.words.add(word);
    }

    public void print() {

    }

    public void addChildElement(TextObject object) {

    }
}
