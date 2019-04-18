package classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceTest {

    Word word;
    Sentence sentence;
    @Before
    public void setUp() throws Exception {
        word = new Word();
        word.getChildClassObjects();
        sentence = new Sentence(word);
    }

    @Test
    public void getChildClassObjects() {
        sentence.getChildClassObjects();
    }
}