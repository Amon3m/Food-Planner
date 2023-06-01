package com.m3.foodplanner.meal.model;

public class Ingredient {
    String ingredient, measure;

    public Ingredient(String ingredient, String measure) {
        this.ingredient = ingredient;
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getMeasure() {
        return measure;
    }


}
