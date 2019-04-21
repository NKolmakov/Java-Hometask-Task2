package classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Book {

    private String text = "";
    private StringBuilder stringBuilder = new StringBuilder();

    public Book(String pathToFile) throws FileNotFoundException,IOException{

            FileReader fileReader = new FileReader(pathToFile);
            int symbol;
            while ((symbol = fileReader.read()) != -1){
                stringBuilder.append((char)symbol);
            }
            this.text = stringBuilder.toString().replaceAll(" +", " ");
    }

    public String getText(){
        return text;
    }
}

//TODO: CREATE OWN EXCEPTION CLASS
//TODO: BOOKHELPER CONSTRUCTOR HAS TO OUT MY OWN MESSAGE
//TODO: STOPPED AT WORD: REQUIRED NEW CONSTRUCTOR