package com.epam.classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Book {

    private String text = "";
    private StringBuilder stringBuilder = new StringBuilder();

    public Book(String pathToFile) throws FileNotFoundException,IOException{

            FileReader fileReader = new FileReader(pathToFile);
            int symbol;
            while ((symbol = fileReader.read()) != -1){
                stringBuilder.append((char)symbol);
            }
            this.text = stringBuilder.toString();
    }

    public String getText(){
        return text;
    }
}