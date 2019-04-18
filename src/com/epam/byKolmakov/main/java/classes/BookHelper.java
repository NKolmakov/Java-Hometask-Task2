package classes;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BookHelper {
    private static BookHelper instance;
    private Book book;
    private final String REGEX_SIGN = "\\. +| +|\\., +|\\.\\r\\n *|[\\.,\\?!;]";
    private final String REGEX_WORD = "\\w+";

    private BookHelper(){
        try{
            book = new Book("text.txt");
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static BookHelper getInstance(){
        if (instance == null){
            synchronized (BookHelper.class){
                if(instance == null){
                    return new BookHelper();
                }
            }
        }
        return instance;
    }

    public Book getBook(){
        return book;
    }

    public String getREGEX_SIGN() {
        return REGEX_SIGN;
    }

    public String getREGEX_WORD(){
        return getREGEX_WORD();
    }
}
