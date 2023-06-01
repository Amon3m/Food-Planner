package com.m3.foodplanner.model;


import androidx.lifecycle.LiveData;

import com.m3.foodplanner.network.NetworkDelegate;

import java.util.List;

public interface RepoInterface {
    public LiveData<List<LocalFavMeal>> getMeals();
    public LiveData<LocalFavMeal>getSelectedMeal(String mealId);
    public void delete( LocalFavMeal meal);
    public void insert(LocalFavMeal meal);


    public void getFilterMealsFromNetwork(NetworkDelegate networkDelegate,char c, String f);

    public void getListFromNetwork(NetworkDelegate networkDelegate,char c);

    public void getSelectedFromNetwork(NetworkDelegate networkDelegate,String f);


    public void getSearchedFromNetwork(NetworkDelegate networkDelegate,char c, String f);




    LiveData<List<LocalMealsWeek>> getAllDayMeals(String day);

    LiveData<LocalMealsWeek> getSelectedDayMeal(String id);


    void insertDayMeal(LocalMealsWeek mealsWeek);

    void deleteDayMeal(LocalMealsWeek mealsWeek);






}
