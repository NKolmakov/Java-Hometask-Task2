package com.epam.handlers;

import com.epam.Main;
import com.epam.classes.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Runner {
    public void run(){
        BookParser parser = BookParser.getInstance();
        BookHelper helper = BookHelper.getInstance();
        try {
            parser.parseBook(new Book("text.txt"));
            System.out.println("Text as set of nested objects:");
            parser.getTextAsObject().print();
            System.out.println();
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("                Sort sentences in ascending order by words amount");
            System.out.println("--------------------------------------------------------------------------------------");
           for(Sentence sentence: helper.sortSentencesByWordsAmount(parser.getTextAsObject())){
               sentence.print();
               System.out.println();
           }
        } catch (FileNotFoundException ex) {
            System.out.println("Book doesn't exist!");
            Main.LOGGER.error("Book not found");
        }catch (IOException ex){
            System.out.println("Can't read book!");
            Main.LOGGER.error("Can't read book!");
        }
    }
}
