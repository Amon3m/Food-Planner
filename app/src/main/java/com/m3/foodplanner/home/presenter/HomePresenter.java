package com.m3.foodplanner.home.presenter;


import android.util.Log;

import com.m3.foodplanner.home.view.HomeViewInterface;
import com.m3.foodplanner.model.AreaList;
import com.m3.foodplanner.model.CategoryList;
import com.m3.foodplanner.model.FilterMealItem;
import com.m3.foodplanner.model.IngredientList;
import com.m3.foodplanner.model.SearchedListMeals;
import com.m3.foodplanner.model.SearchedMeals;
import com.m3.foodplanner.model.SelectedMealsItem;
import com.m3.foodplanner.model.RepoInterface;
import com.m3.foodplanner.network.NetworkDelegate;

import java.util.List;


public class HomePresenter implements HomePresenterInterface, NetworkDelegate {

    private HomeViewInterface view;
    private RepoInterface repoInterface;

    public HomePresenter(HomeViewInterface view , RepoInterface repoInterface){
        this.view =view;
        this.repoInterface =repoInterface;
    }

    @Override
    public void onSuccessResult(List<FilterMealItem> meals) {
        view.dismissProgressBar();
        view.showData(meals);
    }

    @Override
    public void onFailureResult(String errorMessage) {

    }



    @Override
    public void getFilterMeals() {
        Log.e("hii","getFilterMeals()");


        repoInterface.getFilterMealsFromNetwork(this,'a',"Egyptian");
    }

    @Override
    public void getListMeals() {
        Log.e("hii","getList()");
        repoInterface.getListFromNetwork(this,'a');
    }

    @Override
    public void getSelectedMeal(String f) {
        Log.e("hii","getList()");
        repoInterface.getSelectedFromNetwork(this, f);
    }

//    @Override
//    public void getList() {
//
//    }

//    @Override
//    public void getList() {
//        repoInterface.getListFromNetwork(this,'a');
//
//
//    }



    //---------------
    @Override
    public void onSuccessResultAreaList(List<AreaList> meal) {
        view.showDataOfList(meal);
        view.dismissProgressBar2();

        Log.e("hii","onSuccessResultAreaList");


    }

    @Override
    public void onSuccessResultCategoryList(List<CategoryList> meals) {

    }

    @Override
    public void onSuccessResultIngredientList(List<IngredientList> meals) {

    }

    @Override
    public void onSuccessSelectedMeal(List<SelectedMealsItem> meals) {

    }

    @Override
    public void onSuccessSearchedMeal(List<SearchedMeals> meals) {

    }

    @Override
    public void onSuccessSearchedMealsList(List<SearchedListMeals> meals) {

    }

}
