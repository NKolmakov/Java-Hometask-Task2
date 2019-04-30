package com.epam.classes;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class BookTest {

    Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book("text.txt");
    }

    private String getTextFromFile(String path2File) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(path2File);
        StringBuilder stringBuilder = new StringBuilder();
        int symbol;

        while ((symbol = fileReader.read()) != -1){
            stringBuilder.append((char)symbol);
        }

        return stringBuilder.toString();
    }

    @Test
    public void getTextFromExistingFile() throws FileNotFoundException,IOException {
       String expected = getTextFromFile("text.txt");
       String actual = book.getText();

       assertTrue(expected.equals(actual));
    }

    @Test(expected = FileNotFoundException.class)
    public void getTextWrongPathName() throws IOException{
        getTextFromFile("wrongFileName.txt");
    }

}