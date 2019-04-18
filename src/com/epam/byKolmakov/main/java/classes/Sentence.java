package classes;

import interfaces.IHaveChildObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence implements IHaveChildObject {
    private static final String REGEX_SENTENCE = "\\. |\\.$|\\?\\!|[\\?!]";
    private Word word;
    private List<String> sentences = new ArrayList<String>();
    private List<String> signs;
    private List<String> words;

    public Sentence(Word word){
        this.word = word;
        signs = word.getSigns();
        words = word.getChildClassObjects();
        separateBySentences();
        new Subparagraph(this);
    }

    public List getChildClassObjects() {
        return sentences;
    }

    private void separateBySentences(){
        Pattern sentencePattern = Pattern.compile(REGEX_SENTENCE);
        Matcher sentenceMatcher;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            sentenceMatcher = sentencePattern.matcher(signs.get(i));
            if(!sentenceMatcher.find()){
                stringBuilder.append(words.get(i)+signs.get(i));
            }else{
                stringBuilder.append(words.get(i)+signs.get(i));
                sentences.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
        }
        sentences.add(words.get(words.size()-1)+signs.get(signs.size()-1)); //for adding last word in text with sign
    }
}
