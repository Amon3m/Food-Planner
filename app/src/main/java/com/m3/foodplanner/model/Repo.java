package com.m3.foodplanner.model;

import android.content.Context;


import androidx.lifecycle.LiveData;

import com.m3.foodplanner.db.LocalSource;
import com.m3.foodplanner.network.NetworkDelegate;
import com.m3.foodplanner.network.RemoteSource;

import java.util.List;

public class Repo implements RepoInterface{

    private Context context;
    RemoteSource remoteSource;
    LocalSource localSource;
    private static Repo repo = null;

    public static  Repo getInstance(LocalSource localSource , RemoteSource remoteSource ,Context context){
        if (repo == null){
            repo = new Repo(context , localSource , remoteSource);
        }
        return repo;
    }

    public Repo(Context context , LocalSource localSource , RemoteSource remoteSource){
        this.localSource = localSource;
        this.remoteSource =remoteSource;
        this.context =context;
    }



    @Override
    public LiveData<List<LocalFavMeal>> getMeals() {
        return localSource.getCachedMeals();
    }

    @Override
    public LiveData<LocalFavMeal> getSelectedMeal(String mealId) {
        return localSource.getSelectedMeal(mealId);
    }

    @Override
    public void delete(LocalFavMeal meal) {
        localSource.delete(meal);

    }

    @Override
    public void insert(LocalFavMeal meal) {
              localSource.insert(meal);


    }

    @Override
    public void getFilterMealsFromNetwork(NetworkDelegate networkDelegate,char c, String f) {
        remoteSource.enqueueCallFilter(networkDelegate, c,  f);
    }

    @Override
    public void getListFromNetwork(NetworkDelegate networkDelegate, char c) {
        remoteSource.enqueueCallList(networkDelegate,c);
    }

    @Override
    public void getSelectedFromNetwork(NetworkDelegate networkDelegate, String f) {
        remoteSource.enqueueCallSelectedItem(networkDelegate,f);
    }

    @Override
    public void getSearchedFromNetwork(NetworkDelegate networkDelegate, char c, String f) {
        remoteSource.enqueueCallSearched(networkDelegate,c,f);
    }

    @Override
    public LiveData<List<LocalMealsWeek>> getAllDayMeals( String day) {
        return localSource.getAllDayMeals(day);
    }

    @Override
    public LiveData<LocalMealsWeek> getSelectedDayMeal(String id) {
        return localSource.getSelectedDayMeal(id);
    }

    @Override
    public void insertDayMeal(LocalMealsWeek mealsWeek) {
        localSource.insertDayMeal(mealsWeek);

    }

    @Override
    public void deleteDayMeal(LocalMealsWeek mealsWeek) {
        localSource.deleteDayMeal(mealsWeek);

    }

}
