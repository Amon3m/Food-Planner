package com.m3.foodplanner.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.LocalMealsWeek;

@Database(entities = {LocalFavMeal.class, LocalMealsWeek.class}, version = 1)
public abstract class MealsDatabase extends RoomDatabase {

        private static MealsDatabase instance = null;

        public abstract MealsDAO mealsDAO();

        public static synchronized MealsDatabase getInstance(Context context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(), MealsDatabase.class, "mealsDb")
                        .build();
            }
            return instance;
        }
    }

