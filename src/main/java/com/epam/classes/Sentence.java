package com.epam.classes;

import java.util.LinkedList;
import java.util.List;

public class Sentence implements TextObject {
    List<TextObject> words = new LinkedList<TextObject>();
    List<TextObject> punctuations = new LinkedList<TextObject>();

    public void print() {
        for (int i = 0; i < words.size(); i++) {
            words.get(i).print();
            punctuations.get(i).print();
        }
    }

    public void addChildElement(TextObject object) {
        if(object instanceof Word){
            this.words.add((Word)object);
        }else if(object instanceof Punctuation) {
            this.punctuations.add((Punctuation) object);
        }else{
            System.out.println("Class "+object.getClass()+"can't be in sentence");
        }
    }

    public List<TextObject> getElementsByClass(Class class4Search) {
        List<TextObject> elements = new LinkedList<TextObject>();

        if(class4Search.isInstance(this)){
            elements.add(this);
        }else{

            for (TextObject object:words){
                elements.addAll(object.getElementsByClass(class4Search));
            }

            for(TextObject object:punctuations){
                elements.addAll(object.getElementsByClass(class4Search));
            }
        }

        return elements;
    }

    public List<TextObject> getWords(){
        return words;
    }

}
