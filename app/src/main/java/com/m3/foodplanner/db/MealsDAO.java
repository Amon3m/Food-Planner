package com.m3.foodplanner.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.LocalMealsWeek;

import java.util.List;

@Dao
public interface MealsDAO {

    @Query("SELECT * FROM favmeal")
    LiveData<List<LocalFavMeal>> getAllMeals();

    @Query("SELECT * FROM favmeal Where mealID like :id")
    LiveData<LocalFavMeal> getSelectedMeal(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    void insertMeal(LocalFavMeal localFavMeal);

    @Delete
    void deleteMeal(LocalFavMeal localFavMeal);


    @Query("SELECT * FROM weekMeal where day like :day ")
    LiveData<List<LocalMealsWeek>> getAllDayMeals(String day);

    @Query("SELECT * FROM weekMeal Where mealID like :id ")
    LiveData<LocalMealsWeek> getSelectedDayMeal(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    void insertDayMeal(LocalMealsWeek mealsWeek);

    @Delete
    void deleteDayMeal(LocalMealsWeek mealsWeek);
}
