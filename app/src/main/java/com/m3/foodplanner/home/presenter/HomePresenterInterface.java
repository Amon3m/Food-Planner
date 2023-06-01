package com.m3.foodplanner.home.presenter;


import com.m3.foodplanner.model.FilterMealItem;

public interface HomePresenterInterface {
    public void getFilterMeals();
    public void getListMeals();

    public void getSelectedMeal(String f);


}
