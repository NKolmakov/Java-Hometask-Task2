package classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {

    private String initialize(String path){
        StringBuilder text = new StringBuilder();
        try {
            FileReader reader = new FileReader(path);

            while (reader.read() != -1 ){
                text.append(reader.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
