package com.lozyukartem.vegetarianrestaurant.menu;

import com.lozyukartem.vegetarianrestaurant.menu.util.MenuUtil;
import com.lozyukartem.vegetarianrestaurant.salad.Salad;

import java.util.Map;

public final class Menu {

    private static volatile Menu instance = null;
    private Map<String, Salad> salads = null;

    private Menu(){
        salads = MenuUtil.getSalads();
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
