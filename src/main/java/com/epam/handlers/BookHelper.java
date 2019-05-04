package com.epam.handlers;

import com.epam.classes.*;

import java.util.*;

public class BookHelper {
    private static BookHelper instance;

    private BookHelper() {

    }

    public static BookHelper getInstance() {
        if (instance == null) {
            instance = new BookHelper();
            return instance;
        }
        return instance;
    }

    public List<Sentence> sortSentencesByWordsAmount(Text text) {
        List<Sentence> sentences = new LinkedList<Sentence>();
        for (TextObject object : text.getElementsByClass(Sentence.class)) {
            if (object instanceof Sentence) {
                sentences.add((Sentence) object);
            }
        }
        Collections.sort(sentences, new Comparator<Sentence>() {
            public int compare(Sentence o1, Sentence o2) {
                int length1 = o1.getWords().size();
                int length2 = o2.getWords().size();
                int rezult = 0;
                if (length1 < length2) rezult = -1;
                if (length1 > length2) rezult = 1;
                if (length1 == length2) rezult = 0;

                return rezult;
            }
        });

        return sentences;
    }
}
