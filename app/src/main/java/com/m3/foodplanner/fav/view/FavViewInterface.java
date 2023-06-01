package com.m3.foodplanner.fav.view;

import androidx.lifecycle.LiveData;

import com.m3.foodplanner.model.LocalFavMeal;

import java.util.List;

public interface FavViewInterface {
    public LiveData<List<LocalFavMeal>> getMeals();
    public LiveData<LocalFavMeal>getSelectedMeal(String mealId);
    public void delete( LocalFavMeal meal);
}
