package com.lozyukartem.vegetarianrestaurant.salad.util;

import com.lozyukartem.vegetarianrestaurant.salad.Salad;
import com.lozyukartem.vegetarianrestaurant.vegetable.Vegetable;

import java.util.List;

public final class SaladUtil {

    private SaladUtil() {}

    public static void sort(List<Vegetable> list, String mode) {
        switch (mode) {
            case "-c":
                list.sort((value1, value2) -> Double.compare(value1.getCalories(),value2.getCalories()));
                break;
            case "-p":
                list.sort((value1, value2) -> Double.compare(value1.getProteins(), value2.getProteins()));
                break;
            case "-f":
                list.sort((value1, value2) -> Double.compare(value1.getFats(), value2.getFats()));
                break;
            case "-ch":
                list.sort((value1, value2) -> Double.compare(value1.getCarbohydrates(), value2.getCarbohydrates()));
                break;
        }
    }

    public static Salad find(Salad salad, String mode, double start, double end) {
        Salad result = new Salad();
        switch (mode) {
            case "-c":
                salad.getVegetableList().stream()
                        .filter(vegetable -> vegetable.getCalories() >= start && vegetable.getCalories() <= end)
                        .forEach(result::addIngredient);
                break;
            case "-p":
                salad.getVegetableList().stream()
                        .filter(vegetable -> vegetable.getProteins() >= start && vegetable.getProteins() <= end)
                        .forEach(result::addIngredient);
                break;
            case "-f":
                salad.getVegetableList().stream()
                        .filter(vegetable -> vegetable.getFats() >= start && vegetable.getFats() <= end)
                        .forEach(result::addIngredient);
                break;
            case "-ch":
                salad.getVegetableList().stream()
                        .filter(vegetable -> vegetable.getCarbohydrates() >= start && vegetable.getCarbohydrates() <= end)
                        .forEach(result::addIngredient);
                break;
        }

        return result;
    }
    public static String formatNumber(double number) {
        return String.format("%10.2f", number);
    }

    public static String formatString(String string) {
        return String.format("%10s", string);
    }

}
