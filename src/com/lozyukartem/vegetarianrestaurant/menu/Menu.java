package com.lozyukartem.vegetarianrestaurant.menu;

import com.lozyukartem.vegetarianrestaurant.menu.util.MenuUtil;
import com.lozyukartem.vegetarianrestaurant.salad.Salad;
import com.lozyukartem.vegetarianrestaurant.salad.util.SaladUtil;

import java.util.List;

public final class Menu {

    private static volatile Menu instance = null;
    private List<Salad> salads = null;

    private Menu(){
        salads = MenuUtil.loadSaladList();
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

    public List<Salad> getSalads() {
        return salads;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(SaladUtil.formatString("Salad"))
                .append(SaladUtil.formatString("cal"))
                .append(SaladUtil.formatString("prot"))
                .append(SaladUtil.formatString("fats"))
                .append(SaladUtil.formatString("carb\n"));
        builder.append("--------------------------------------------------\n");

        salads.forEach(salad -> {
            builder.append(SaladUtil.formatString(salad.getName()))
                    .append(SaladUtil.formatNumber(salad.getCalories()))
                    .append(SaladUtil.formatNumber(salad.getProteins()))
                    .append(SaladUtil.formatNumber(salad.getFats()))
                    .append(SaladUtil.formatNumber(salad.getCarbohydrates()))
                    .append("\n");
        });

        return builder.toString();
    }
}
