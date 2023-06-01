package com.m3.foodplanner.search.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.m3.foodplanner.R;
import com.m3.foodplanner.model.SearchedMeals;

import java.util.ArrayList;


    public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
        private ArrayList<SearchedMeals> mealsList;
        private Context context;
        OnSearchedMealClick listener;

        public SearchAdapter(ArrayList<SearchedMeals> mealsList, Context context, OnSearchedMealClick listener) {
            this.mealsList = mealsList;
            this.context = context;
            this.listener = listener;
        }

        public void setProductsList(ArrayList<SearchedMeals> mealsList) {
            this.mealsList = mealsList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.daily_inspiration_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            Log.i("test", "onCreateViewHolder");
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            SearchedMeals searchedMeals = mealsList.get(position);
            holder.titleText.setText(searchedMeals.getStrMeal());

            // Load the thumbnail image using Glide
            Glide.with(holder.itemView.getContext())
                    .load(searchedMeals.getStrMealThumb())
                    .into(holder.imageView);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onMealSearchedClick(searchedMeals);
                }

            });

//        holder.addFav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onClick(product);
//            }
//        });
        }

        public void setList(ArrayList<SearchedMeals> itemList) {
            this.mealsList = itemList;
            this.notifyDataSetChanged();
        }


        @Override
        public int getItemCount() {
            return mealsList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView titleText;

            public ViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.daily_imageView);
                titleText = itemView.findViewById(R.id.user_title);


            }
        }

    }
