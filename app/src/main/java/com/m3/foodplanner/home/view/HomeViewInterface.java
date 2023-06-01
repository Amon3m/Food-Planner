package com.m3.foodplanner.home.view;

import com.m3.foodplanner.model.AreaList;
import com.m3.foodplanner.model.FilterMealItem;

import java.util.List;

public interface HomeViewInterface {

    void showData(List<FilterMealItem> filterMealItems);
    void showDataOfList(List<AreaList> list);


    void dismissProgressBar();
    void dismissProgressBar2();


}
