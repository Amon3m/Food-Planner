package com.m3.foodplanner.meal.view;

import com.m3.foodplanner.meal.model.Ingredient;
import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.LocalMealsWeek;
import com.m3.foodplanner.model.SelectedMealsItem;

import java.util.ArrayList;
import java.util.List;

public interface MealDetailsViewInterface {
    void showData(List<SelectedMealsItem> meals, ArrayList<Ingredient> ingredientList);
    public void addMeal(LocalFavMeal meal);
    void  addDayMeal(LocalMealsWeek mealsWeek);
}
