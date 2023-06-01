package com.m3.foodplanner.MealsList.presenter;

import com.m3.foodplanner.MealsList.view.MealsListFragmentInterface;
import com.m3.foodplanner.meal.view.MealDetailsViewInterface;
import com.m3.foodplanner.model.AreaList;
import com.m3.foodplanner.model.CategoryList;
import com.m3.foodplanner.model.FilterMealItem;
import com.m3.foodplanner.model.IngredientList;
import com.m3.foodplanner.model.RepoInterface;
import com.m3.foodplanner.model.SearchedListMeals;
import com.m3.foodplanner.model.SearchedMeals;
import com.m3.foodplanner.model.SelectedMealsItem;
import com.m3.foodplanner.network.NetworkDelegate;

import java.util.List;

public class MealListPresenter implements NetworkDelegate,MealListPresenterInterface {
    String mealID;
    private MealsListFragmentInterface view;
    private RepoInterface repoInterface;

    public MealListPresenter(MealsListFragmentInterface view , RepoInterface repoInterface,String mealID){
        this.view =view;
        this.repoInterface =repoInterface;
        this.mealID=mealID;}


        @Override
    public void getSelectedList(String f) {
            repoInterface.getFilterMealsFromNetwork(this,'a',f);


        }

    @Override
    public void getSelectedCatList(String f) {
        repoInterface.getFilterMealsFromNetwork(this,'c',f);


    }

    @Override
    public void getMeal() {

    }

    @Override
    public void onSuccessResult(List<FilterMealItem> meals) {
        view.showData(meals);

    }

    @Override
    public void onFailureResult(String errorMessage) {

    }

    @Override
    public void onSuccessResultAreaList(List<AreaList> meals) {

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
