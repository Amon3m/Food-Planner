package com.m3.foodplanner.search.presenter;

import com.m3.foodplanner.network.NetworkDelegate;

public interface SearchPresenterInterface {
    public void getListMeals();
    public void getSearchedFromNetwork(char c, String f);
}
