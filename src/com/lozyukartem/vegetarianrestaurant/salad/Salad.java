package com.lozyukartem.vegetarianrestaurant.salad;

import com.lozyukartem.vegetarianrestaurant.menu.SaladName;
import com.lozyukartem.vegetarianrestaurant.vegetable.Vegetable;

import java.util.Map;

public class Salad {

    private Map<Integer, Vegetable> ingredients;
    private SaladName name;

    public Map<Integer, Vegetable> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Integer, Vegetable> ingredients) {
        this.ingredients = ingredients;
    }

    public SaladName getName() {
        return name;
    }

    public void setName(SaladName name) {
        this.name = name;
    }
}
