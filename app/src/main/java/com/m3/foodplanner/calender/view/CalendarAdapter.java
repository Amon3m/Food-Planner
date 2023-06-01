package com.m3.foodplanner.calender.view;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.m3.foodplanner.R;
import com.m3.foodplanner.fav.view.FavAdapter;
import com.m3.foodplanner.fav.view.OnFavListener;
import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.LocalMealsWeek;

import java.util.ArrayList;



    public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {
        private ArrayList<LocalMealsWeek> mealsList;
        private Context context;
        OncalenderListener listener;

        public CalendarAdapter(ArrayList<LocalMealsWeek> mealsList, Context context,OncalenderListener listener) {
            this.mealsList = mealsList;
            this.context = context;
            this.listener=listener;

        }

        public void setProductsList(ArrayList<LocalMealsWeek> mealsList) {
            this.mealsList = mealsList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.local_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            Log.i("test", "onCreateViewHolder");
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            LocalMealsWeek localMealsWeek = mealsList.get(position);
            holder.titleText.setText(localMealsWeek.getStrMeal());

            // Load the thumbnail image using Glide
            Glide.with(holder.itemView.getContext())
                    .load(localMealsWeek.getStrMealThumb())
                    .into(holder.imageView);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onMealClick(localMealsWeek);
                }

            });

            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDeleteClick(localMealsWeek);
                }
            });
        }
        public void setList(ArrayList<LocalMealsWeek> itemList){
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
            FloatingActionButton delete;

            public ViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.local_imageView);
                titleText = itemView.findViewById(R.id.local_title);
                delete=itemView.findViewById(R.id.local_floating);


            }
        }
    }


