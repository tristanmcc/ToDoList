package ToDoLy;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;

public class ToDoListMain implements Serializable {

    public static void main(String[] args) throws ParseException, IOException {
        UserInput startVariable = new UserInput();
        startVariable.displayMenu();
    }
}



