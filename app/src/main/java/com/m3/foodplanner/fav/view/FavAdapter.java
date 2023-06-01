package com.m3.foodplanner.fav.view;

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
import com.m3.foodplanner.home.view.OnMealClickListener;
import com.m3.foodplanner.model.FilterMealItem;
import com.m3.foodplanner.model.LocalFavMeal;

import java.util.ArrayList;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {
    private ArrayList<LocalFavMeal> mealsList;
    private Context context;
    OnFavListener listener;

    public FavAdapter(ArrayList<LocalFavMeal> mealsList, Context context,OnFavListener listener) {
        this.mealsList = mealsList;
        this.context = context;
        this.listener=listener;

    }

    public void setProductsList(ArrayList<LocalFavMeal> mealsList) {
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
        LocalFavMeal localFavMeal = mealsList.get(position);
        holder.titleText.setText(localFavMeal.getStrMeal());

        // Load the thumbnail image using Glide
        Glide.with(holder.itemView.getContext())
                .load(localFavMeal.getStrMealThumb())
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMealClick(localFavMeal);
            }

        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDeleteClick(localFavMeal);
            }
        });
    }
    public void setList(ArrayList<LocalFavMeal> itemList){
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
