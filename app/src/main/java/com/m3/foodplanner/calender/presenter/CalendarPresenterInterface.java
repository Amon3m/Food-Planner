package com.m3.foodplanner.calender.presenter;

import androidx.lifecycle.LiveData;

import com.m3.foodplanner.model.LocalMealsWeek;

import java.util.List;

public interface CalendarPresenterInterface {

    LiveData<LocalMealsWeek> getSelectedDayMeal(String id,String day);


    LiveData<List<LocalMealsWeek>> getAllDayMeals(String day);




    void deleteDayMeal(LocalMealsWeek mealsWeek);
}
