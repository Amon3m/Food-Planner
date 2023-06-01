package com.m3.foodplanner.search.view;

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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.m3.foodplanner.MealsList.view.MealsListFragmentInterface;
import com.m3.foodplanner.R;
import com.m3.foodplanner.db.ConcreteLocalSource;
import com.m3.foodplanner.fav.presenter.FavPresenter;
import com.m3.foodplanner.fav.view.FavAdapter;
import com.m3.foodplanner.home.presenter.HomePresenter;
import com.m3.foodplanner.home.view.HomeFragmentDirections;
import com.m3.foodplanner.model.CategoryList;
import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.Repo;
import com.m3.foodplanner.model.RepoInterface;
import com.m3.foodplanner.model.SearchedMeals;
import com.m3.foodplanner.network.ApiClient;
import com.m3.foodplanner.search.presenter.SearchPresenter;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment implements SearchViewInterface,OnCatClickListener,OnSearchedMealClick {
    SearchPresenter presenter;
    RecyclerView recyclerView;
    SearchAdapter adapterSearch;
    RecyclerView searchRecycler;
    CatAdapter catAdapter;
    List<CategoryList> categoryList;
    ImageButton srBtn;
    EditText srTxt;
    List<SearchedMeals> searchedMeals;
    ProgressBar searchPrg;
    ProgressBar catPrg;

    View rootView;

    public SearchFragment() {
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
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        srBtn=view.findViewById(R.id.search_btn);
        srTxt=view.findViewById(R.id.search_edt);
        searchPrg=view.findViewById(R.id.search_progress_bar);
        catPrg=view.findViewById(R.id.cat_progress_bar);
        searchPrg.setVisibility(View.GONE);

        categoryList=new ArrayList<>();
        recyclerView = view.findViewById(R.id.cat_rec);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        catAdapter = new CatAdapter((ArrayList<CategoryList>) categoryList, requireContext() ,this);
        recyclerView.setAdapter(catAdapter);

        presenter = new SearchPresenter(this, Repo.getInstance(ConcreteLocalSource.getInstance(requireContext()), ApiClient.getInstance(), requireContext()));
        presenter.getListMeals();
        rootView=view;


        searchedMeals=new ArrayList<>();
        searchRecycler = view.findViewById(R.id.recycler_search);
        searchRecycler.setHasFixedSize(true);
        LinearLayoutManager manager2 = new LinearLayoutManager(getActivity());
        manager2.setOrientation(LinearLayoutManager.VERTICAL);
        searchRecycler.setLayoutManager(manager2);
        adapterSearch= new SearchAdapter((ArrayList<SearchedMeals>) searchedMeals, requireContext() ,this);
        searchRecycler.setAdapter(adapterSearch);
        srBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchedWord =srTxt.getText().toString();
                searchPrg.setVisibility(View.VISIBLE);
                presenter.getSearchedFromNetwork('s',searchedWord);
            }
        });

    }

    @Override
    public void onClick(CategoryList item) {

        SearchFragmentDirections.ActionSearchFragmentToMealsListFragment action=
                SearchFragmentDirections.actionSearchFragmentToMealsListFragment("",item.getStrCategory());
              Navigation.findNavController(rootView).navigate(action);

//        HomeFragmentDirections.ActionHomeFragmentToMealsListFragment action =
//                HomeFragmentDirections.actionHomeFragmentToMealsListFragment(meal.getStrArea());
//        Navigation.findNavController(rootView).navigate(action);

    }

    @Override
    public void showData(List<SearchedMeals> meal) {
            adapterSearch.setList((ArrayList<SearchedMeals>) meal);
    }

    @Override
    public void showDataOfList(List<CategoryList> list) {
        catAdapter.setList((ArrayList<CategoryList>) list);
    }

    @Override
    public void dismissProgressBar() {
     searchPrg.setVisibility(View.GONE);
    }

    @Override
    public void dismissProgressBar2() {
        catPrg.setVisibility(View.GONE);

    }

    @Override
    public void onMealSearchedClick(SearchedMeals meal) {
        SearchFragmentDirections.ActionSearchFragmentToMealDetailsFragment action=
                SearchFragmentDirections.actionSearchFragmentToMealDetailsFragment(meal.getIdMeal());

        Navigation.findNavController(rootView).navigate(action);
//        HomeFragmentDirections.ActionHomeFragmentToMealsListFragment action =
//                HomeFragmentDirections.actionHomeFragmentToMealsListFragment(meal.getStrArea());
//        Navigation.findNavController(rootView).navigate(action);
    }
}