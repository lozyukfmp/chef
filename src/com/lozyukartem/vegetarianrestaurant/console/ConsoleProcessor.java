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
    private static final String SHOW_SALAD_PATTERN = "show salad (\\w+) (-c|-p|-f|-ch)";
    public static final String FIND_BY_INTERVAL_PATTERN = "find (-c|-p|-f|-ch)\\[(\\d+),(\\d+)\\]";

    private static BufferedReader reader;
    private static PrintWriter writer;

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

    public void process(Menu menu) {
        String value = "";
        writer.println(menu);
        Salad salad = null;

        Pattern findPattern = Pattern.compile(FIND_BY_INTERVAL_PATTERN);

        while (!EXIT.equals(value)) {
            try {
                value = reader.readLine();
                if (value.matches(SHOW_SALAD_PATTERN)) {
                    String saladName = value.split(" ")[2];
                    String sortMode = value.split(" ")[3];

                    salad = MenuUtil.findSalad(menu, saladName);
                    SaladUtil.sort(salad.getVegetableList(), sortMode);
                    writer.println(salad);

                } else if (value.matches(SALAD_LIST_PATTERN)) {
                    writer.println(menu);
                } else if (value.matches(FIND_BY_INTERVAL_PATTERN)) {
                    Matcher matcher = findPattern.matcher(value);
                    if (matcher.find()) {
                        String mode = matcher.group(1);
                        double start = Double.parseDouble(matcher.group(2));
                        double end = Double.parseDouble(matcher.group(3));

                        writer.println(SaladUtil.find(salad, mode, start, end));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
