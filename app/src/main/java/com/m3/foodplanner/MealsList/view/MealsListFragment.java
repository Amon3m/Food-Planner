package com.m3.foodplanner.MealsList.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m3.foodplanner.MealsList.presenter.MealListPresenter;
import com.m3.foodplanner.R;
import com.m3.foodplanner.db.ConcreteLocalSource;
import com.m3.foodplanner.home.view.DailyInspirationAdapter;
import com.m3.foodplanner.home.view.HomeFragmentDirections;
import com.m3.foodplanner.home.view.OnMealClickListener;
import com.m3.foodplanner.meal.presenter.MealPresenter;
import com.m3.foodplanner.meal.view.MealDetailsFragmentArgs;
import com.m3.foodplanner.model.FilterMealItem;
import com.m3.foodplanner.model.Repo;
import com.m3.foodplanner.network.ApiClient;

import java.util.ArrayList;
import java.util.List;


public class MealsListFragment extends Fragment implements MealsListFragmentInterface, OnMealClickListener {

    String mealID;
    String mealCat;
    MealListPresenter presenter;
    List<FilterMealItem> meals = new ArrayList<>();
    MealsListAdapter adapter;
    RecyclerView recyclerView;
    private View rootView;


    public MealsListFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meals_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mealID= MealsListFragmentArgs.fromBundle(getArguments()).getCountryName();
        mealCat=MealsListFragmentArgs.fromBundle(getArguments()).getCatStr();

        Log.e("list",mealID);
        rootView = view;

        recyclerView = view.findViewById(R.id.list_rec);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new MealsListAdapter((ArrayList<FilterMealItem>) meals, requireContext() ,this);
        recyclerView.setAdapter(adapter);
        presenter = new MealListPresenter(this, Repo.getInstance(ConcreteLocalSource.getInstance(requireContext()), ApiClient.getInstance(), requireContext()),mealID);
        if (!mealID.isEmpty()){
            presenter.getSelectedList(mealID);}
        else {presenter.getSelectedCatList(mealCat);}

    }

    @Override
    public void showData(List<FilterMealItem> filterMealItems) {
        adapter.setList((ArrayList<FilterMealItem>) filterMealItems);

    }

    @Override
    public void onMealClick(FilterMealItem meal) {

//        HomeFragmentDirections.ActionHomeFragmentToMealDetailsFragment action=
//                HomeFragmentDirections.actionHomeFragmentToMealDetailsFragment(meal.getIdMeal());
//
//        Navigation.findNavController(rootView).navigate(action);

        MealsListFragmentDirections.ActionMealsListFragmentToMealDetailsFragment action=
                MealsListFragmentDirections.actionMealsListFragmentToMealDetailsFragment(meal.getIdMeal());
                Navigation.findNavController(rootView).navigate(action);

    }


}