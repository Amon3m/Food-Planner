package com.m3.foodplanner.meal.presenter;

import androidx.lifecycle.LiveData;

import com.m3.foodplanner.meal.model.Ingredient;
import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.LocalMealsWeek;
import com.m3.foodplanner.model.SelectedMealsItem;

import java.util.ArrayList;

public interface MealPresenterInterface {
    public void getSelectedMeal(String f);
    public void getMeal();
    public void addMeal(LocalFavMeal meal);
    public LiveData<LocalFavMeal> getSelectedMealLocal(String mealId);
    ArrayList<Ingredient> getLocalIngredient(LocalFavMeal selectedMealsItem);

    void  addDayMeal(LocalMealsWeek mealsWeek);



}
