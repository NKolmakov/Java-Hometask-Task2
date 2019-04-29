package com.epam.handlers;

import com.epam.classes.Book;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Runner {
    public void run(){
        BookParser parser = BookParser.getInstance();
        BookHelper helper = BookHelper.getInstance();
        try {
            parser.parseBook(new Book("text.txt"));
            System.out.println("Given text:");
            parser.getText().print();
            System.out.println();
            System.out.println("----------------------------------------------------------------------------");
            helper.printSentenceByWordsAmount(parser.getText());
        } catch (FileNotFoundException ex) {
            System.out.println("Book doesn't exist!");
        }catch (IOException ex){
            System.out.println("Can't read book!");
        }
    }
}
