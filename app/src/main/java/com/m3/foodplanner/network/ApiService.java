package com.m3.foodplanner.network;



import com.m3.foodplanner.model.AreaListResponse;
import com.m3.foodplanner.model.CategoryListResponse;
import com.m3.foodplanner.model.IngredientListResponse;
import com.m3.foodplanner.model.FilterMealsResponse;
import com.m3.foodplanner.model.SearchedListMeals;
import com.m3.foodplanner.model.SearchedListResponse;
import com.m3.foodplanner.model.SearchedResponse;
import com.m3.foodplanner.model.SelectedMealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/json/v1/1/filter.php?")
    Call<FilterMealsResponse> getMealsByCategory(@Query("c") String category);
    @GET("api/json/v1/1/filter.php?")
    Call<FilterMealsResponse> getMealsByArea(@Query("a") String area);

    @GET("api/json/v1/1/filter.php?")
    Call<FilterMealsResponse> getMealsByIngredient(@Query("i") String ingredient);
//listof----------

    @GET("api/json/v1/1/list.php?")
    Call<CategoryListResponse> getListOfCategory(@Query("c") String category);

    @GET("api/json/v1/1/list.php?")
    Call<AreaListResponse> getListOfArea(@Query("a") String area);

    @GET("api/json/v1/1/list.php?")
    Call<IngredientListResponse> getListOfIngredient(@Query("i") String ingredient);

    @GET("api/json/v1/1/lookup.php?")
    Call<SelectedMealResponse> getSelectedMael(@Query("i") String ingredient);

    @GET("api/json/v1/1/search.php?")
    Call<SearchedResponse> getSearchedMael(@Query("s") String ingredient);

    @GET("api/json/v1/1/search.php?")
    Call<SearchedListResponse> getSearchedMaelList(@Query("f") String ingredient);
//
//    www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata
//    List all meals by first letter
//    www.themealdb.com/api/json/v1/1/search.php?f=a



    //   www.themealdb.com/api/json/v1/1/lookup.php?i=52772

//    www.themealdb.com/api/json/v1/1/list.php?c=list
//    www.themealdb.com/api/json/v1/1/list.php?a=list
//    www.themealdb.com/api/json/v1/1/list.php?i=list


}
