package com.lozyukartem.vegetarianrestaurant.salad;

import com.lozyukartem.vegetarianrestaurant.salad.util.SaladUtil;
import com.lozyukartem.vegetarianrestaurant.vegetable.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class Salad {

    private List<Vegetable> ingredients;
    private String name;

    public Salad() {
        ingredients = new ArrayList<>();

    }

    public List<Vegetable> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Vegetable> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addIngredient(Vegetable vegetable) {
        ingredients.add(vegetable);
    }

    public List<Vegetable> getVegetableList() {
        return ingredients;
    }

    public double getCalories() {
        return getVegetableList().stream().mapToDouble(vegetable -> vegetable.getCalories()).sum();
    }

    public double getProteins() {
        return getVegetableList().stream().mapToDouble(vegetable -> vegetable.getProteins()).sum();
    }

    public double getFats() {
        return getVegetableList().stream().mapToDouble(vegetable -> vegetable.getFats()).sum();
    }

    public double getCarbohydrates() {
        return getVegetableList().stream().mapToDouble(vegetable -> vegetable.getCarbohydrates()).sum();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(SaladUtil.formatString("Vegetable"))
                .append(SaladUtil.formatString("cal"))
                .append(SaladUtil.formatString("prot"))
                .append(SaladUtil.formatString("fats"))
                .append(SaladUtil.formatString("carb\n"));
        builder.append("--------------------------------------------------\n");

        ingredients.forEach(vegetable -> {
            builder.append(SaladUtil.formatString(vegetable.name().toLowerCase()))
                    .append(SaladUtil.formatNumber(vegetable.getCalories()))
                    .append(SaladUtil.formatNumber(vegetable.getProteins()))
                    .append(SaladUtil.formatNumber(vegetable.getFats()))
                    .append(SaladUtil.formatNumber(vegetable.getCarbohydrates()))
                    .append("\n");
        });

        return builder.toString();
    }
}
