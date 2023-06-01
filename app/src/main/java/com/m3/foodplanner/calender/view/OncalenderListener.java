package com.m3.foodplanner.calender.view;

import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.LocalMealsWeek;

public interface OncalenderListener {
    void onMealClick(LocalMealsWeek meal);
    void onDeleteClick(LocalMealsWeek meal);
}
