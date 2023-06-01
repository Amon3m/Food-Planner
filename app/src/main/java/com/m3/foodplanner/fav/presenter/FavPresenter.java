package com.m3.foodplanner.fav.presenter;

import androidx.lifecycle.LiveData;

import com.m3.foodplanner.fav.view.FavViewInterface;
import com.m3.foodplanner.meal.view.MealDetailsViewInterface;
import com.m3.foodplanner.model.AreaList;
import com.m3.foodplanner.model.CategoryList;
import com.m3.foodplanner.model.FilterMealItem;
import com.m3.foodplanner.model.IngredientList;
import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.RepoInterface;
import com.m3.foodplanner.model.SearchedListMeals;
import com.m3.foodplanner.model.SearchedMeals;
import com.m3.foodplanner.model.SelectedMealsItem;
import com.m3.foodplanner.network.NetworkDelegate;

import java.util.List;

public class FavPresenter implements NetworkDelegate,FavPresenterInterface{
    private FavViewInterface view;
    private RepoInterface repo;

    public FavPresenter(FavViewInterface view, RepoInterface repoInterface) {
        this.view = view;
        this.repo= repoInterface;
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

    @Override
    public LiveData<List<LocalFavMeal>> getMeals() {
        return repo.getMeals();
    }



    @Override
    public void delete(LocalFavMeal meal) {
        repo.delete(meal);

    }
}
