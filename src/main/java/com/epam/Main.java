package com.epam;

import com.epam.classes.Book;
import com.epam.handlers.BookParser;
import com.epam.handlers.Runner;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();
    }
}
