package classes;

import interfaces.ITextObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Symbol implements ITextObject {
    private FileReader fileReader;
    private StringBuilder stringBuilder = new StringBuilder();

    private void getTextAsString(){
        try {
            fileReader = new FileReader("text.txt");           //todo: path to text file must be in another place
            int symbol;
            while ((symbol = fileReader.read()) != -1){
                stringBuilder.append((char)symbol);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTextFileAsString(){
        getTextAsString();
        return stringBuilder.toString();
    }
}
