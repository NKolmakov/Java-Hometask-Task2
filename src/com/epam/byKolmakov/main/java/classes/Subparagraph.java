package classes;

import interfaces.TextObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subparagraph implements TextObject {
   List<Sentence> sentences = new LinkedList<Sentence>();

    public void addSentence(Sentence sentence) {
       this.sentences.add(sentence);
    }

    public void print() {

    }
}
