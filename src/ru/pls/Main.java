package ru.pls;
import java.io.IOException;

import static ru.pls.Menu.mainMenu;
public class Main {
    public static void main(String[] args){
        try {
            mainMenu ();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}