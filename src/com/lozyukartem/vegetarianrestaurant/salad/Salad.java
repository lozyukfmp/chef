package com.lozyukartem.vegetarianrestaurant.salad;

import com.lozyukartem.vegetarianrestaurant.vegetable.Vegetable;

import java.util.Map;

public class Salad {

    private Map<Vegetable, Integer> ingredients;
    private String name;

    public Map<Vegetable, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Vegetable, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addIngredient(Vegetable vegetable, Integer portion) {
        ingredients.put(vegetable, portion);
    }
}
