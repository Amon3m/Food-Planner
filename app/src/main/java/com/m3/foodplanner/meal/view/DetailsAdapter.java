package com.m3.foodplanner.meal.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.m3.foodplanner.R;

import com.m3.foodplanner.home.view.OnMealClickListener;
import com.m3.foodplanner.meal.model.Ingredient;

import java.util.ArrayList;


    public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
        private ArrayList<Ingredient> ingredientLists;
        private Context context;


        public DetailsAdapter(ArrayList<Ingredient> ingredientLists, Context context) {
            this.ingredientLists = ingredientLists;
            this.context = context;
        }

        public void setAreaList(ArrayList<Ingredient> ingredientLists) {
            this.ingredientLists = ingredientLists;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.ingredients_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            Log.i("test", "onCreateViewHolder");
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Ingredient ingredient = ingredientLists.get(position);
            holder.titleingredients.setText(ingredient.getIngredient());

            holder.meseuare.setText(ingredient.getMeasure());




        }


        public void setList(ArrayList<Ingredient> ingredientLists){
            this.ingredientLists = ingredientLists;
            this.notifyDataSetChanged();
        }


        @Override
        public int getItemCount() {

            return ingredientLists.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView titleingredients;
            TextView meseuare;
            ImageButton addBtn;
            ImageButton favBtn;

            public ViewHolder(View itemView) {
                super(itemView);
                titleingredients = itemView.findViewById(R.id.ingredients_name);
                meseuare=itemView.findViewById(R.id.ingredients_mes);


            }
        }
    }

