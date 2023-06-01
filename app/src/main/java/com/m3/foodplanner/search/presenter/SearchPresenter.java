package com.m3.foodplanner.search.presenter;

import android.util.Log;
import android.view.View;

import com.m3.foodplanner.model.AreaList;
import com.m3.foodplanner.model.CategoryList;
import com.m3.foodplanner.model.FilterMealItem;
import com.m3.foodplanner.model.IngredientList;
import com.m3.foodplanner.model.RepoInterface;
import com.m3.foodplanner.model.SearchedListMeals;
import com.m3.foodplanner.model.SearchedMeals;
import com.m3.foodplanner.model.SelectedMealsItem;
import com.m3.foodplanner.network.NetworkDelegate;
import com.m3.foodplanner.search.view.SearchViewInterface;

import java.util.List;

public class SearchPresenter implements SearchPresenterInterface, NetworkDelegate {
    private SearchViewInterface view;
    private RepoInterface repoInterface;

    public SearchPresenter(SearchViewInterface view , RepoInterface repoInterface){
        this.view =view;
        this.repoInterface =repoInterface;
    }

    @Override
    public void onSuccessResult(List<FilterMealItem> meals) {

    }

    @Override
    public void onFailureResult(String errorMessage) {

    }

    @Override
    public void onSuccessResultAreaList(List<AreaList> meals) {

    }

    @Override
    public void onSuccessResultCategoryList(List<CategoryList> meals) {
        view.showDataOfList(meals);
    }

    @Override
    public void onSuccessResultIngredientList(List<IngredientList> meals) {

    }

    @Override
    public void onSuccessSelectedMeal(List<SelectedMealsItem> meals) {

    }

    @Override
    public void onSuccessSearchedMeal(List<SearchedMeals> meals) {
        view.showData(meals);
        Log.e("GG","onSuccessSearchedMeal");
        view.dismissProgressBar();
    }

    @Override
    public void onSuccessSearchedMealsList(List<SearchedListMeals> meals) {

    }

    @Override
    public void getListMeals() {
        Log.e("hii","getList()");
        repoInterface.getListFromNetwork(this,'c');
        view.dismissProgressBar2();

    }

    @Override
    public void getSearchedFromNetwork( char c, String f) {
        repoInterface.getSearchedFromNetwork(this,c,f);
        Log.e("GG","getSearchedFromNetwork");

    }
}
