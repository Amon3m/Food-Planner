package com.m3.foodplanner.calender.view;

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
import android.widget.Button;

import com.m3.foodplanner.R;
import com.m3.foodplanner.calender.presenter.CalendarPresenter;
import com.m3.foodplanner.db.ConcreteLocalSource;
import com.m3.foodplanner.fav.presenter.FavPresenter;
import com.m3.foodplanner.fav.view.FavAdapter;
import com.m3.foodplanner.fav.view.FavFragmentDirections;
import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.LocalMealsWeek;
import com.m3.foodplanner.model.Repo;
import com.m3.foodplanner.network.ApiClient;

import java.util.ArrayList;
import java.util.List;


public class CalendarFragment extends Fragment implements CalendarViewInterface ,OncalenderListener{
    CalendarPresenter presenter;
    RecyclerView recyclerView;
    CalendarAdapter adapter;
    List<LocalMealsWeek> mealsWeeks;
    View rootView;
    Button stDay;
    Button sunDay;
    Button monDay;
    Button tueDay;
    Button wedDay;
    Button thuDay;
    Button friDay;


    public CalendarFragment() {
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
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        stDay=view.findViewById(R.id.saturday_week_btn);
        sunDay=view.findViewById(R.id.sunday_week_btn);
        monDay=view.findViewById(R.id.monday_week);
        tueDay=view.findViewById(R.id.tuesday_week);
        wedDay=view.findViewById(R.id.wednesday_week);
        thuDay=view.findViewById(R.id.thursday_week);
        friDay=view.findViewById(R.id.friday_week);

        mealsWeeks=new ArrayList<>();
        recyclerView = view.findViewById(R.id.week_rec);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new CalendarAdapter((ArrayList<LocalMealsWeek>) mealsWeeks, requireContext() ,this);
        recyclerView.setAdapter(adapter);


        presenter = new CalendarPresenter(this, Repo.getInstance(ConcreteLocalSource.getInstance(requireContext()), ApiClient.getInstance(), requireContext()));
        rootView=view;




        stDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getAllDayMeals("stDay").observe(getViewLifecycleOwner(), new Observer<List<LocalMealsWeek>>() {
                    @Override
                    public void onChanged(List<LocalMealsWeek> localMealsWeeks) {
                        adapter.setList((ArrayList<LocalMealsWeek>) localMealsWeeks);
                    }
                });
            }
        });
        sunDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getAllDayMeals("sunDay").observe(getViewLifecycleOwner(), new Observer<List<LocalMealsWeek>>() {
                    @Override
                    public void onChanged(List<LocalMealsWeek> localMealsWeeks) {
                        adapter.setList((ArrayList<LocalMealsWeek>) localMealsWeeks);
                    }
                });

            }
        });
        monDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getAllDayMeals("monDay").observe(getViewLifecycleOwner(), new Observer<List<LocalMealsWeek>>() {
                    @Override
                    public void onChanged(List<LocalMealsWeek> localMealsWeeks) {
                        adapter.setList((ArrayList<LocalMealsWeek>) localMealsWeeks);
                    }
                });


            }
        });
        tueDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getAllDayMeals("tueDay").observe(getViewLifecycleOwner(), new Observer<List<LocalMealsWeek>>() {
                    @Override
                    public void onChanged(List<LocalMealsWeek> localMealsWeeks) {
                        adapter.setList((ArrayList<LocalMealsWeek>) localMealsWeeks);
                    }
                });


            }
        });
        wedDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getAllDayMeals("wedDay").observe(getViewLifecycleOwner(), new Observer<List<LocalMealsWeek>>() {
                    @Override
                    public void onChanged(List<LocalMealsWeek> localMealsWeeks) {
                        adapter.setList((ArrayList<LocalMealsWeek>) localMealsWeeks);
                    }
                });

            }
        });
        thuDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getAllDayMeals("thuDay").observe(getViewLifecycleOwner(), new Observer<List<LocalMealsWeek>>() {
                    @Override
                    public void onChanged(List<LocalMealsWeek> localMealsWeeks) {
                        adapter.setList((ArrayList<LocalMealsWeek>) localMealsWeeks);
                    }
                });


            }
        });
        friDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getAllDayMeals("friDay").observe(getViewLifecycleOwner(), new Observer<List<LocalMealsWeek>>() {
                    @Override
                    public void onChanged(List<LocalMealsWeek> localMealsWeeks) {
                        adapter.setList((ArrayList<LocalMealsWeek>) localMealsWeeks);
                    }
                });

            }
        });
    }

    @Override
    public LiveData<List<LocalMealsWeek>> getAllDayMeals() {
        return null;
    }

    @Override
    public LiveData<LocalMealsWeek> getSelectedDayMeal(String id, String day) {
        return null;
    }

    @Override
    public LiveData<List<LocalMealsWeek>> getAllDayMeals(String day) {
        return null;
    }



    @Override
    public void deleteDayMeal(LocalMealsWeek mealsWeek) {

    }

    @Override
    public void onMealClick(LocalMealsWeek meal) {
        CalendarFragmentDirections.ActionCalendarFragmentToMealDetailsFragment action=
                CalendarFragmentDirections.actionCalendarFragmentToMealDetailsFragment(meal.getMealID());
        action.setIsLocal(true);
        action.setIsWeek(true);



        Navigation.findNavController(rootView).navigate(action);

    }

    @Override
    public void onDeleteClick(LocalMealsWeek meal) {
        presenter.deleteDayMeal(meal);
    }
}