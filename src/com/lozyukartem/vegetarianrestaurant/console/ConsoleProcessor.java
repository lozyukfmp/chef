package com.lozyukartem.vegetarianrestaurant.console;

import com.lozyukartem.vegetarianrestaurant.menu.Menu;
import com.lozyukartem.vegetarianrestaurant.menu.util.MenuUtil;
import com.lozyukartem.vegetarianrestaurant.salad.Salad;
import com.lozyukartem.vegetarianrestaurant.salad.util.SaladUtil;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ConsoleProcessor {

    private static volatile ConsoleProcessor instance = null;

    private static final String EXIT = "exit";
    private static final String SALAD_LIST_PATTERN = "salad list";
    private static final String SHOW_SALAD_PATTERN = "select salad (\\w+) (-c|-p|-f|-ch)";
    private static final String FIND_BY_INTERVAL_PATTERN = "find (-c|-p|-f|-ch)\\[(\\d+),(\\d+)\\]";
    private static final String SALAD_NOT_FOUND = "Salad with such name not found.";
    private static final String INCORRECT_COMMAND = "Incorrect command.\nType\nsalad list - to show salad list\n" +
            "select salad [saladName] [-c|-f|-p|-ch] - to show salad sorted by selected mode\n" +
            "find [-c|-f|-p|-ch][firstNum,secondNum] to show ingredients of salad sorted by selected mode\n";
    private static final String CHOOSE_SALAD = "Choose salad from salad list";

    private BufferedReader reader;
    private PrintWriter writer;
    private Menu menu;
    private Salad currentSalad;


    private ConsoleProcessor() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(new OutputStreamWriter(System.out), true);
    }

    public static ConsoleProcessor getInstance() {

        if (instance == null) {
            synchronized (ConsoleProcessor.class) {
                if (instance == null) {
                    instance = new ConsoleProcessor();
                } else {
                    return instance;
                }
            }
        }

        return instance;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void process() {
        String value = "";
        writer.println(menu);

        while (!EXIT.equals(value)) {
            try {
                value = reader.readLine();

                if (value.matches(SHOW_SALAD_PATTERN)) {
                    processShowSaladQuery(value);
                } else if (value.matches(SALAD_LIST_PATTERN)) {
                    processSaladListQuery();
                } else if (value.matches(FIND_BY_INTERVAL_PATTERN)) {
                    processFindQuery(value);
                } else {
                    writer.println(INCORRECT_COMMAND);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processSaladListQuery() {
        currentSalad = null;
        writer.println(menu);
    }

    private void processShowSaladQuery(String value) {
        String saladName = value.split(" ")[2];
        String sortMode = value.split(" ")[3];

        currentSalad = MenuUtil.findSalad(menu, saladName);
        if (currentSalad == null) {
            writer.println(SALAD_NOT_FOUND);
        } else {
            SaladUtil.sort(currentSalad.getVegetableList(), sortMode);
            writer.println(currentSalad);
        }
    }

    private void processFindQuery(String value) {

        Pattern findPattern = Pattern.compile(FIND_BY_INTERVAL_PATTERN);

        if (currentSalad == null) {
            writer.println(CHOOSE_SALAD);
        } else {
            Matcher matcher = findPattern.matcher(value);
            if (matcher.find()) {
                String mode = matcher.group(1);
                double start = Double.parseDouble(matcher.group(2));
                double end = Double.parseDouble(matcher.group(3));

                writer.println(SaladUtil.find(currentSalad, mode, start, end));
            }
        }
    }
}
