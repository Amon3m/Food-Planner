package com.m3.foodplanner.search.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m3.foodplanner.R;
import com.m3.foodplanner.home.view.OnCountryClickListener;
import com.m3.foodplanner.home.view.WorldAdapter;
import com.m3.foodplanner.model.AreaList;
import com.m3.foodplanner.model.CategoryList;

import java.util.ArrayList;


public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {
        private ArrayList<CategoryList> list;
        private Context context;
        OnCatClickListener listener;


        public CatAdapter(ArrayList<CategoryList> list, Context context, OnCatClickListener listener) {
            this.list = list;
            this.context = context;
            this.listener=listener;
        }

        public void setAreaList(ArrayList<CategoryList> list) {
            this.list = list;
        }


        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.world_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            Log.i("test", "onCreateViewHolder");
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            CategoryList categoryList = list.get(position);
            holder.titleText.setText(categoryList.getStrCategory());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(categoryList);
                }
            });


        }
        public void setList(ArrayList<CategoryList> categoryList){
            this.list = categoryList;
            this.notifyDataSetChanged();
        }


        @Override
        public int getItemCount() {

            return list.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView titleText;

            public ViewHolder(View itemView) {
                super(itemView);
                titleText = itemView.findViewById(R.id.country_title);

            }
        }
    }

