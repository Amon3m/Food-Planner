package com.m3.foodplanner.home.view;


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
import com.m3.foodplanner.model.FilterMealItem;

import java.util.ArrayList;


public class DailyInspirationAdapter extends RecyclerView.Adapter<DailyInspirationAdapter.ViewHolder> {
    private ArrayList<FilterMealItem> mealsList;
    private Context context;
    OnMealClickListener listener;

    public DailyInspirationAdapter(ArrayList<FilterMealItem> mealsList, Context context,OnMealClickListener listener) {
        this.mealsList = mealsList;
        this.context = context;
        this.listener=listener;
    }

    public void setProductsList(ArrayList<FilterMealItem> mealsList) {
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
        FilterMealItem filterMealItem = mealsList.get(position);
        holder.titleText.setText(filterMealItem.getStrMeal());

        // Load the thumbnail image using Glide
        Glide.with(holder.itemView.getContext())
                .load(filterMealItem.getStrMealThumb())
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMealClick(filterMealItem);
            }

        });

//        holder.addFav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onClick(product);
//            }
//        });
    }
    public void setList(ArrayList<FilterMealItem> itemList){
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