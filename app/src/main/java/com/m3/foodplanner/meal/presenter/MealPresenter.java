package com.m3.foodplanner.meal.presenter;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.m3.foodplanner.meal.view.MealDetailsViewInterface;
import com.m3.foodplanner.model.AreaList;
import com.m3.foodplanner.model.CategoryList;
import com.m3.foodplanner.model.FilterMealItem;
import com.m3.foodplanner.meal.model.Ingredient;
import com.m3.foodplanner.model.IngredientList;
import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.LocalMealsWeek;
import com.m3.foodplanner.model.RepoInterface;
import com.m3.foodplanner.model.SearchedListMeals;
import com.m3.foodplanner.model.SearchedMeals;
import com.m3.foodplanner.model.SelectedMealsItem;
import com.m3.foodplanner.network.NetworkDelegate;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MealPresenter implements NetworkDelegate,MealPresenterInterface {
    String mealID;
    private MealDetailsViewInterface view;
    private RepoInterface repoInterface;

    public MealPresenter(MealDetailsViewInterface view , RepoInterface repoInterface,String mealID){
        this.view =view;
        this.repoInterface =repoInterface;
        this.mealID=mealID;

        Log.e("MealPresenter new",mealID);


    }

    @Override
    public void onSuccessResult(List<FilterMealItem> meals) {

    }

    @Override
    public void onFailureResult(String errorMessage) {

        Log.e("onFailureResult new",errorMessage);


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
    public void onSuccessSelectedMeal(List<SelectedMealsItem> SelectedMeals) {

        Log.e("newhii","onSuccessSelectedMeal");

        SelectedMealsItem meal = SelectedMeals.get(0);
        ArrayList<Ingredient> ingredientList = getIngredient(meal);
        view.showData(SelectedMeals,ingredientList);


    }

    private ArrayList<Ingredient> getIngredient(SelectedMealsItem selectedMealsItem) {
        ArrayList<Ingredient> myIngredientList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String ingredient = null;
            try {
                ingredient = (String) selectedMealsItem.getClass().getMethod("getStrIngredient" + i).invoke(selectedMealsItem);

                String measure = (String) selectedMealsItem.getClass().getMethod("getStrMeasure" + i).invoke(selectedMealsItem);

                if (ingredient != null && !ingredient.isEmpty() && measure != null && !measure.isEmpty()) {
                    myIngredientList.add(new Ingredient(ingredient, measure));
                }
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return myIngredientList;
    }

    @Override
    public void onSuccessSearchedMeal(List<SearchedMeals> meals) {

    }

    @Override
    public void onSuccessSearchedMealsList(List<SearchedListMeals> meals) {

    }

    @Override
    public void getSelectedMeal(String f) {
        mealID=f;
        Log.e("getSelectedMeal new",mealID);



    }

    @Override
    public void getMeal() {
        Log.e("getMeal",mealID);

        repoInterface.getSelectedFromNetwork(this, mealID);

    }

    @Override
    public void addMeal(LocalFavMeal meal) {
        repoInterface.insert(meal);
    }

    @Override
    public LiveData<LocalFavMeal> getSelectedMealLocal(String id) {
        return repoInterface.getSelectedMeal(id);
    }

    @Override
    public ArrayList<Ingredient> getLocalIngredient(LocalFavMeal LocalFavMeal) {
        ArrayList<Ingredient> myIngredientList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String ingredient = null;
            try {
                ingredient = (String) LocalFavMeal.getClass().getMethod("getStrIngredien" + i).invoke(LocalFavMeal);

                String measure = (String) LocalFavMeal.getClass().getMethod("getStrMeasure" + i).invoke(LocalFavMeal);

                if (ingredient != null && !ingredient.isEmpty() && measure != null && !measure.isEmpty()) {
                    myIngredientList.add(new Ingredient(ingredient, measure));
                }
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return myIngredientList;
    }

    @Override
    public void addDayMeal(LocalMealsWeek mealsWeek) {
        repoInterface.insertDayMeal(mealsWeek);
    }
}
