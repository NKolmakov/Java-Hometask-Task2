package classes;

import org.junit.*;

public class WordTest {

    Word word;
    @Before
    public void setUp() throws Exception {
       word = new Word();
    }

    @Test
    public void getChildClassObjects(){
        word.getChildClassObjects();
    }
}