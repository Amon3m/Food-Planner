package com.m3.foodplanner.calender.presenter;

import androidx.lifecycle.LiveData;

import com.m3.foodplanner.calender.view.CalendarViewInterface;
import com.m3.foodplanner.fav.view.FavViewInterface;
import com.m3.foodplanner.model.LocalMealsWeek;
import com.m3.foodplanner.model.RepoInterface;

import java.util.List;

public class CalendarPresenter implements CalendarPresenterInterface{

    private CalendarViewInterface view;
    private RepoInterface repo;

    public CalendarPresenter(CalendarViewInterface view, RepoInterface repoInterface) {
        this.view = view;
        this.repo= repoInterface;
    }


    @Override
    public LiveData<LocalMealsWeek> getSelectedDayMeal(String id, String day) {
        return null;
    }

    @Override
    public LiveData<List<LocalMealsWeek>> getAllDayMeals(String day) {
        return repo.getAllDayMeals(day);
    }



    @Override
    public void deleteDayMeal(LocalMealsWeek mealsWeek) {
        repo.deleteDayMeal(mealsWeek);

    }
}
