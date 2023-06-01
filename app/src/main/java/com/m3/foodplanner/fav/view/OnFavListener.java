package com.m3.foodplanner.fav.view;

import com.m3.foodplanner.model.LocalFavMeal;

public interface OnFavListener {
    void onMealClick(LocalFavMeal meal);
    void onDeleteClick(LocalFavMeal meal);

}
