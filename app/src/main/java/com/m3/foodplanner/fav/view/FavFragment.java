package com.m3.foodplanner.fav.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m3.foodplanner.R;
import com.m3.foodplanner.db.ConcreteLocalSource;
import com.m3.foodplanner.fav.presenter.FavPresenter;

import com.m3.foodplanner.home.view.HomeFragmentDirections;
import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.Repo;
import com.m3.foodplanner.network.ApiClient;

import java.util.ArrayList;
import java.util.List;


public class FavFragment extends Fragment implements FavViewInterface ,OnFavListener {

    FavPresenter presenter;
    RecyclerView recyclerView;
    FavAdapter adapter;
    List<LocalFavMeal> localFavMeal;
    View rootView;



    public FavFragment() {
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
        return inflater.inflate(R.layout.fragment_fav, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        localFavMeal=new ArrayList<>();
        recyclerView = view.findViewById(R.id.fav_rec);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new FavAdapter((ArrayList<LocalFavMeal>) localFavMeal, requireContext() ,this);
        recyclerView.setAdapter(adapter);


        presenter = new FavPresenter(this, Repo.getInstance(ConcreteLocalSource.getInstance(requireContext()), ApiClient.getInstance(), requireContext()));
        presenter.getMeals().observe(getViewLifecycleOwner(), new Observer<List<LocalFavMeal>>() {
            @Override
            public void onChanged(List<LocalFavMeal> localFavMeals) {
                adapter.setList((ArrayList<LocalFavMeal>) localFavMeals);
            }
        });
        rootView=view;
    }

    @Override
    public LiveData<List<LocalFavMeal>> getMeals() {
        return null;
    }

    @Override
    public LiveData<LocalFavMeal> getSelectedMeal(String mealId) {
        return null;
    }

    @Override
    public void delete(LocalFavMeal meal) {

    }

    @Override
    public void onMealClick(LocalFavMeal meal) {
        FavFragmentDirections.ActionFavFragmentToMealDetailsFragment action=
                FavFragmentDirections.actionFavFragmentToMealDetailsFragment(meal.getMealID());
        action.setIsLocal(true);


        Navigation.findNavController(rootView).navigate(action);
    }

    @Override
    public void onDeleteClick(LocalFavMeal meal) {
        presenter.delete(meal);

    }
}