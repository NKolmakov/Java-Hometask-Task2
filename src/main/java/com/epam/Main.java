package com.epam;

import com.epam.classes.Book;
import com.epam.handlers.BookParser;
import com.epam.handlers.Runner;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();
    }
}

//TODO: create method to get chapter name
//TODO: correct method print() in Chapter class

//TODO: add Punctuation in Sentence class
//TODO: correct method print() in Sentence class. It has to print word and sing as whole.