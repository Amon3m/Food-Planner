package com.m3.foodplanner.home.view;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.m3.foodplanner.R;
import com.m3.foodplanner.db.ConcreteLocalSource;
import com.m3.foodplanner.home.presenter.HomePresenter;
import com.m3.foodplanner.meal.view.MealDetailsFragment;
import com.m3.foodplanner.model.AreaList;
import com.m3.foodplanner.model.FilterMealItem;
import com.m3.foodplanner.model.Repo;
import com.m3.foodplanner.network.ApiClient;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements HomeViewInterface,OnMealClickListener,OnCountryClickListener{


     List<FilterMealItem> meals = new ArrayList<>();
     List<AreaList>areaLists=new ArrayList<>();
     RecyclerView mealsList;
     RecyclerView country;
     DailyInspirationAdapter adapter;
     WorldAdapter worldAdapter;
     HomePresenter homePresenter;
     ProgressBar progressBar;
     ProgressBar progressBar2;

    private View rootView;


    public HomeFragment() {
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        meals = new ArrayList<>();
        progressBar = view.findViewById(R.id.ins_list_progressbar);
        progressBar2 = view.findViewById(R.id.world_list_progressbar);

        mealsList = view.findViewById(R.id.daily_inspiration_list);
        mealsList.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mealsList.setLayoutManager(manager);
        adapter = new DailyInspirationAdapter((ArrayList<FilterMealItem>) meals, requireContext() ,this);
        mealsList.setAdapter(adapter);

        homePresenter = new HomePresenter(this, Repo.getInstance(ConcreteLocalSource.getInstance(requireContext()), ApiClient.getInstance(), requireContext()));
        homePresenter.getFilterMeals();
        homePresenter.getListMeals();

        country = view.findViewById(R.id.world_list);
        country.setHasFixedSize(true);
        GridLayoutManager manager2 = new GridLayoutManager(getActivity(),2);
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        country.setLayoutManager(manager2);
        worldAdapter = new WorldAdapter((ArrayList<AreaList>) areaLists, requireContext(),this);
        country.setAdapter(worldAdapter);
        rootView=view;
    }
    @Override
    public void showData(List<FilterMealItem> meals) {
        adapter.setList((ArrayList<FilterMealItem>) meals);
    }

    @Override
    public void showDataOfList(List<AreaList> list) {
        worldAdapter.setList((ArrayList<AreaList>) list);
    }



    @Override
    public void dismissProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void dismissProgressBar2() {
        progressBar2.setVisibility(View.GONE);

    }

    public void onClick(FilterMealItem filterMealItem) {
        // Handle the click event as needed
        // For example, add the product to favorites or perform any other action
    }

    @Override
    public void onMealClick(FilterMealItem meal) {
        //nav
        HomeFragmentDirections.ActionHomeFragmentToMealDetailsFragment action=
                HomeFragmentDirections.actionHomeFragmentToMealDetailsFragment(meal.getIdMeal());

        Navigation.findNavController(rootView).navigate(action);
    }





    @Override
    public void onCountryClick(AreaList meal) {
        HomeFragmentDirections.ActionHomeFragmentToMealsListFragment action =
                HomeFragmentDirections.actionHomeFragmentToMealsListFragment(meal.getStrArea(),"");
        Navigation.findNavController(rootView).navigate(action);

    }
}