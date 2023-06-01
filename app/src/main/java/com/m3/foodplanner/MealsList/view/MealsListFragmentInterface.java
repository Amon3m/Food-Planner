package com.m3.foodplanner.MealsList.view;

import com.m3.foodplanner.meal.model.Ingredient;
import com.m3.foodplanner.model.FilterMealItem;
import com.m3.foodplanner.model.SelectedMealsItem;

import java.util.ArrayList;
import java.util.List;

public interface MealsListFragmentInterface {
    void showData(List<FilterMealItem> filterMealItems);

}
