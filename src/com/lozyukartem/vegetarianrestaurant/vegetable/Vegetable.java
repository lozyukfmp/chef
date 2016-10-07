package com.lozyukartem.vegetarianrestaurant.vegetable;

public enum Vegetable {
    CARROT(33, 1.3, 0.1, 7),
    EGGPLANT(33, 1.3, 0.1, 7),
    CUCUMBER(15, 0.8, 0, 3),
    BEET(48, 1.7, 0, 10.8),
    CAULIFLOWER(29, 2.5, 0, 4.9),
    PEPPER(23, 1.3, 0, 4.7),
    CABBAGE(28, 1.8, 0, 5.4),
    GARLIC(106, 6.5, 0, 21.2),
    SORREL(19, 0.6, 0, 4.2);

    private double calories;
    private double proteins;
    private double carbohydrates;
    private double fats;

    Vegetable(double calories, double proteins, double fats, double carbohydrates) {
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public double getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFats() {
        return fats;
    }
}
