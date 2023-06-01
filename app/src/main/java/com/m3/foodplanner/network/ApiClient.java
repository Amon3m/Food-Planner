package com.m3.foodplanner.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.m3.foodplanner.model.AreaListResponse;
import com.m3.foodplanner.model.CategoryListResponse;
import com.m3.foodplanner.model.IngredientListResponse;
import com.m3.foodplanner.model.FilterMealsResponse;
import com.m3.foodplanner.model.SearchedListResponse;
import com.m3.foodplanner.model.SearchedResponse;
import com.m3.foodplanner.model.SelectedMealResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient implements RemoteSource{
    private static final String BASE_URL = "https://themealdb.com/";

    ApiService apiService;
    private static ApiClient apiClient = null;

    private ApiClient() {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static  ApiClient getInstance(){
        if (apiClient == null){
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    public void  startCallSelectedMeal(NetworkDelegate networkDelegate, String f){
        Call<SelectedMealResponse> call = apiService.getSelectedMael(f);
        call.enqueue(new Callback<SelectedMealResponse>() {
            @Override
            public void onResponse(Call<SelectedMealResponse> call, Response<SelectedMealResponse> response) {
                if (response.isSuccessful()) {
                    SelectedMealResponse selectedMealResponse = response.body();
                    if (selectedMealResponse != null) {
                        networkDelegate.onSuccessSelectedMeal(selectedMealResponse.getMeals());
                        Log.e("hii","startCallFilter");

                    }
                }
            }
            @Override
            public void onFailure(Call<SelectedMealResponse> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());
            }
        });

    }
    public void startCallSearch(NetworkDelegate networkDelegate, char c, String f) {

        if (c == 's') {
            Call<SearchedResponse> call = apiService.getSearchedMael(f);
            call.enqueue(new Callback<SearchedResponse>() {
                @Override
                public void onResponse(Call<SearchedResponse> call, Response<SearchedResponse> response) {
                    if (response.isSuccessful()) {
                        SearchedResponse searchedResponse = response.body();
                        if (searchedResponse != null) {
                            networkDelegate.onSuccessSearchedMeal(searchedResponse.getMeals());
                            Log.e("hii","startCallFilter");

                        }
                    }
                }
                @Override
                public void onFailure(Call<SearchedResponse> call, Throwable t) {
                    networkDelegate.onFailureResult(t.getMessage());
                }
            });

        } else if (c == 'f') {
            Call<SearchedListResponse> call = apiService.getSearchedMaelList(f);
            call.enqueue(new Callback<SearchedListResponse>() {
                @Override
                public void onResponse(Call<SearchedListResponse> call, Response<SearchedListResponse> response) {
                    if (response.isSuccessful()) {
                        SearchedListResponse SearchedListResponse = response.body();
                        if (SearchedListResponse != null) {
                            networkDelegate.onSuccessSearchedMealsList(SearchedListResponse.getMeals());
                        }
                    }
                }

                @Override
                public void onFailure(Call<SearchedListResponse> call, Throwable t) {
                    networkDelegate.onFailureResult(t.getMessage());
                }
            });
        }
    }





    public void startCallFilter(NetworkDelegate networkDelegate, char c, String f) {

        if (c == 'a') {
            Call<FilterMealsResponse> call = apiService.getMealsByArea(f);
            call.enqueue(new Callback<FilterMealsResponse>() {
                @Override
                public void onResponse(Call<FilterMealsResponse> call, Response<FilterMealsResponse> response) {
                    if (response.isSuccessful()) {
                        FilterMealsResponse filterMealsResponse = response.body();
                        if (filterMealsResponse != null) {
                            networkDelegate.onSuccessResult(filterMealsResponse.getMeals());
                            Log.e("hii","startCallFilter");

                        } 
                    }
                }
                @Override
                public void onFailure(Call<FilterMealsResponse> call, Throwable t) {
                    networkDelegate.onFailureResult(t.getMessage());
                }
            });
            
        } else if (c == 'c') {
            Call<FilterMealsResponse> call = apiService.getMealsByCategory(f);
            call.enqueue(new Callback<FilterMealsResponse>() {
                @Override
                public void onResponse(Call<FilterMealsResponse> call, Response<FilterMealsResponse> response) {
                    if (response.isSuccessful()) {
                        FilterMealsResponse filterMealsResponse = response.body();
                        if (filterMealsResponse != null) {
                            networkDelegate.onSuccessResult(filterMealsResponse.getMeals());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FilterMealsResponse> call, Throwable t) {
                    networkDelegate.onFailureResult(t.getMessage());
                }
            });
        }else if (c == 'i') {
            Call<FilterMealsResponse> call = apiService.getMealsByIngredient(f);
            call.enqueue(new Callback<FilterMealsResponse>() {
                @Override
                public void onResponse(Call<FilterMealsResponse> call, Response<FilterMealsResponse> response) {
                    if (response.isSuccessful()) {
                        FilterMealsResponse filterMealsResponse = response.body();
                        if (filterMealsResponse != null) {
                            networkDelegate.onSuccessResult(filterMealsResponse.getMeals());
                        } 
                    } 
                }

                @Override
                public void onFailure(Call<FilterMealsResponse> call, Throwable t) {
                    networkDelegate.onFailureResult(t.getMessage());
                }
            });
        }
    }

    public void startCallList(NetworkDelegate networkDelegate, char c) {
        String API_LIST="list";
        if (c == 'a') {
            Call<AreaListResponse> call = apiService.getListOfArea(API_LIST);
            call.enqueue(new Callback<AreaListResponse>() {
                @Override
                public void onResponse(Call<AreaListResponse> call, Response<AreaListResponse> response) {
                    if (response.isSuccessful()) {
                        AreaListResponse areaListResponse = response.body();
                        if (areaListResponse != null) {
                            Log.e("hii","response.isSuccessful()");
                            networkDelegate.onSuccessResultAreaList(areaListResponse.getAreaList());
                        }
                    }
                }
                @Override
                public void onFailure(Call<AreaListResponse> call, Throwable t) {
                    networkDelegate.onFailureResult(t.getMessage());
                    Log.e("hii","response.isSuccessful()");

                }
            });

        } else if (c == 'c') {
            Call<CategoryListResponse> call = apiService.getListOfCategory(API_LIST);
            call.enqueue(new Callback<CategoryListResponse>() {
                @Override
                public void onResponse(Call<CategoryListResponse> call, Response<CategoryListResponse> response) {
                    if (response.isSuccessful()) {
                        CategoryListResponse categoryListResponse = response.body();
                        if (categoryListResponse != null) {
                            networkDelegate.onSuccessResultCategoryList(categoryListResponse.getCategory());
                        }
                    }
                }

                @Override
                public void onFailure(Call<CategoryListResponse> call, Throwable t) {
                    networkDelegate.onFailureResult(t.getMessage());
                }
            });
        }else if (c == 'i') {
            Call<IngredientListResponse> call = apiService.getListOfIngredient(API_LIST);
            call.enqueue(new Callback<IngredientListResponse>() {
                @Override
                public void onResponse(Call<IngredientListResponse> call, Response<IngredientListResponse> response) {
                    if (response.isSuccessful()) {
                        IngredientListResponse ingredientListResponse = response.body();
                        if (ingredientListResponse != null) {
                            networkDelegate.onSuccessResultIngredientList(ingredientListResponse.getIngredients());
                        }
                    }
                }

                @Override
                public void onFailure(Call<IngredientListResponse> call, Throwable t) {
                    networkDelegate.onFailureResult(t.getMessage());
                }
            });
        }
    }


//    public void startCall(NetworkDelegate networkDelegate) {
//        Call<Response> call = apiService.getAllProducts();
//        call.enqueue(new Callback<Response>() {
//            @Override
//            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//                if (response.isSuccessful()) {
//                    Response Response = response.body();
//                    if (Response != null) {
//                        networkDelegate.onSuccessResult(Response.getProducts());
//
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Response> call, Throwable t) {
//                networkDelegate.onFailureResult(t.getMessage());
//            }
//        });
//
//    }

    @Override
    public void enqueueCallFilter(NetworkDelegate networkDelegate, char c, String f) {
        ApiClient.getInstance().startCallFilter(networkDelegate, c, f);
    }


    @Override
    public void enqueueCallList(NetworkDelegate networkDelegate, char c)
    {
        ApiClient.getInstance().startCallList(networkDelegate, c);
    }

    @Override
    public void enqueueCallSelectedItem(NetworkDelegate networkDelegate, String f) {
        ApiClient.getInstance().startCallSelectedMeal(networkDelegate, f);

    }

    @Override
    public void enqueueCallSearched(NetworkDelegate networkDelegate, char c, String f) {
        ApiClient.getInstance().startCallSearch(networkDelegate, c, f);

    }

}
