package classes;

import interfaces.IHaveChildObject;

import java.util.ArrayList;
import java.util.List;

public class Subparagraph implements IHaveChildObject {
    private List<String> subparagraphs = new ArrayList<String>();
    private List<String> sentences;

    public Subparagraph(Sentence sentence){
        this.sentences = sentence.getChildClassObjects();
    }
    public List getChildClassObjects() {
        return subparagraphs;
    }

    private void separateBySubparagraphs(){

    }
}
