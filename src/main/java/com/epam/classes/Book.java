package com.epam.classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Book {

    private String text = "";
    private String path2File = "";

    public Book(String path2File) throws FileNotFoundException,IOException{
        this.text = readFromFile(path2File);
        this.path2File = path2File;
    }

    public String getText(){
        return text;
    }

    public String getPath2File(){
        return path2File;
    }

    private String readFromFile(String path2File) throws FileNotFoundException, IOException{

        FileReader fileReader = new FileReader(path2File);
        StringBuilder stringBuilder = new StringBuilder();
        int symbol;

        while ((symbol = fileReader.read()) != -1){
            stringBuilder.append((char)symbol);
        }

        return stringBuilder.toString();
    }
}