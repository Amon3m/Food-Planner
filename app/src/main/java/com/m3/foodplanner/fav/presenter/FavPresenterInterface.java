package com.m3.foodplanner.fav.presenter;

import androidx.lifecycle.LiveData;

import com.m3.foodplanner.model.LocalFavMeal;

import java.util.List;

public interface FavPresenterInterface {
    public LiveData<List<LocalFavMeal>> getMeals();

    public void delete( LocalFavMeal meal);
}
