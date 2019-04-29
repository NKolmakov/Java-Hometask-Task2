package com.epam.classes;

import java.util.List;

public interface TextObject {

    //method to display text from book as chain of objects
    void print();

    //method allow add child element to classes except for Word and Punctuation
    void addChildElement(TextObject object);

    //method to get objects from structure of nested elements by class name
    List<TextObject> getElementsByClass(Class class4Search);
}
