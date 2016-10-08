package com.lozyukartem.vegetarianrestaurant.main;

import com.lozyukartem.vegetarianrestaurant.console.ConsoleProcessor;
import com.lozyukartem.vegetarianrestaurant.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = Menu.getInstance();
        ConsoleProcessor consoleProcessor = ConsoleProcessor.getInstance();
        consoleProcessor.setMenu(menu);

        consoleProcessor.process();
    }
}
