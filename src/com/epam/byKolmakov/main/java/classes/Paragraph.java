package classes;

import interfaces.IHaveChildObject;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements IHaveChildObject {
   private List<String> paragraphs = new ArrayList<String>();



    public List getChildClassObjects() {
        return null;
    }
}
