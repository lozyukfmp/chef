package com.lozyukartem.vegetarianrestaurant.menu;

import com.lozyukartem.vegetarianrestaurant.salad.Salad;

import java.util.HashMap;
import java.util.Map;

public final class Menu {
    private static volatile Menu instance = null;
    private Map<SaladName, Salad> salads = null;

    private Menu(){
        salads = new HashMap<>();
    }

    public static Menu getInstance() {
        if (instance == null) {
            synchronized (Menu.class) {
                if (instance == null) {
                    instance = new Menu();
                } else {
                    return instance;
                }
            }
        }

        return instance;
    }

}
