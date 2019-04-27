import classes.Book;
import classes.BookParser;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            BookParser bookParser = BookParser.getInstance();
            bookParser.parseBook(new Book("text.txt"));
        }catch (FileNotFoundException ex){
            System.out.println("Error");
        }catch (IOException ex){
            System.out.println("Error");
        }
    }
}
//TODO: CREATE MY OWN EXCEPTION CLASS
//TODO: CHECK SIMPLE TYPE OF CLASSES TO CAST IN ADD METHOD
//TODO: VOID FILLLIST DOESN'T CONSIDER A SITUATION, WHEN MATCHES NOT FOUND

//TODO: stopped at BookParser method startParse(). To create all regulars
//TODO: проверить, нужны ли вообще списки элементов к классе парсер, скорее всего разбить только на главы, а дальше парсерами по убывающей