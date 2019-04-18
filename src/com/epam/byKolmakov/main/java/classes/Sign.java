package classes;

import interfaces.ITextObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign implements ITextObject {
    BookHelper bookHelper = BookHelper.getInstance();

    private LinkedList<String> signs = new LinkedList<String>();

    public void separateBySigns() {
        Pattern signPattern = Pattern.compile(bookHelper.getREGEX_SIGN());
        Matcher signMatcher = signPattern.matcher(bookHelper.getBook().getText()); //todo: also temp code
        while (signMatcher.find()) {
            String sign = bookHelper.getBook().getText().substring(signMatcher.start(), signMatcher.end());
            signs.add(sign);
        }
    }

    public LinkedList<String> getSigns(){
        return signs;
    }
}
