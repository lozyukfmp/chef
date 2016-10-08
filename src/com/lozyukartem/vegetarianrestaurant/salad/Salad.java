package com.lozyukartem.vegetarianrestaurant.salad;

import com.lozyukartem.vegetarianrestaurant.vegetable.Vegetable;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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

}
