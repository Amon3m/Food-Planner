package com.m3.foodplanner.search.view;

import com.m3.foodplanner.model.AreaList;
import com.m3.foodplanner.model.CategoryList;
import com.m3.foodplanner.model.FilterMealItem;
import com.m3.foodplanner.model.SearchedMeals;

import java.util.List;

public interface SearchViewInterface {
    void showData(List<SearchedMeals> meal);
    void showDataOfList(List<CategoryList> list);


    void dismissProgressBar();
    void dismissProgressBar2();
}
