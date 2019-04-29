package com.epam.classes;

import java.util.List;

public interface TextObject {
    void print();
    void addChildElement(TextObject object);
   // List<TextObject> getElements(Class clas);
    List<TextObject> getElementsByClass(Class class4Search);
}
