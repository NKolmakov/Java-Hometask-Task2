package com.epam.handlers;

import com.epam.classes.Book;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Runner {
    public void run(){
        BookParser parser = BookParser.getInstance();
        try {
            parser.parseBook(new Book("text.txt"));
            parser.getText().print();
        } catch (FileNotFoundException ex) {
            System.out.println("Book doesn't exist!");
        }catch (IOException ex){
            System.out.println("Can't read book!");
        }
    }
}
