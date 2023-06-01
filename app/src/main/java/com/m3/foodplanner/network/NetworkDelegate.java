package com.m3.foodplanner.network;

import com.m3.foodplanner.model.AreaList;
import com.m3.foodplanner.model.CategoryList;
import com.m3.foodplanner.model.FilterMealItem;
import com.m3.foodplanner.model.IngredientList;
import com.m3.foodplanner.model.SearchedListMeals;
import com.m3.foodplanner.model.SearchedMeals;
import com.m3.foodplanner.model.SelectedMealsItem;

import java.util.List;

public interface NetworkDelegate {
    public void onSuccessResult(List<FilterMealItem> meals);
    public void onFailureResult(String errorMessage);

    public void onSuccessResultAreaList(List<AreaList> meals);
    public void onSuccessResultCategoryList(List<CategoryList> meals);
    public void onSuccessResultIngredientList(List<IngredientList> meals);

    public void onSuccessSelectedMeal(List<SelectedMealsItem> meals);

    public void onSuccessSearchedMeal(List<SearchedMeals> meals);

    public void onSuccessSearchedMealsList(List<SearchedListMeals> meals);





}
