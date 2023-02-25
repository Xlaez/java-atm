package oop.com.atm;

import java.io.IOException;

public class Main extends Menu {
    public static void main(String[] args) throws IOException {
        Menu optionMenu = new Menu();
        optionMenu.getLogin();
    }
}