package com.m3.foodplanner.meal.view;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.m3.foodplanner.R;
import com.m3.foodplanner.db.ConcreteLocalSource;
import com.m3.foodplanner.meal.presenter.MealPresenter;
import com.m3.foodplanner.meal.model.Ingredient;
import com.m3.foodplanner.model.LocalFavMeal;
import com.m3.foodplanner.model.LocalMealsWeek;
import com.m3.foodplanner.model.Repo;
import com.m3.foodplanner.model.SelectedMealsItem;
import com.m3.foodplanner.network.ApiClient;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;



import java.util.ArrayList;
import java.util.List;


public class MealDetailsFragment extends Fragment implements MealDetailsViewInterface {

    String mealID;
    MealPresenter presenter;
    TextView mealTitle;
    TextView mealIns;
    ImageView mealImage;
    RecyclerView mealRecyclerView;
    DetailsAdapter adapter;
    List<Ingredient> meal= new ArrayList<>();
    YouTubePlayerView youtubePlayerView;
    LocalFavMeal localFavMeal;
    LocalMealsWeek mealsWeek;
    Button stDay;
    Button sunDay;
    Button monDay;
    Button tueDay;
    Button wedDay;
    Button thuDay;
    Button friDay;

    ImageButton addBtn;
    ImageButton favBtn;


    public MealDetailsFragment() {
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
        return inflater.inflate(R.layout.fragment_meal_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        meal = new ArrayList<>();
        favBtn=view.findViewById(R.id.add_to_fav);
        addBtn=view.findViewById(R.id.add_to_week);

        mealID=MealDetailsFragmentArgs.fromBundle(getArguments()).getIdMeal();
        Boolean isLocal=MealDetailsFragmentArgs.fromBundle(getArguments()).getIsLocal();
        Log.e("isLocal hii",isLocal.toString());

        Log.e("newhii from onv",mealID);
        presenter = new MealPresenter(this, Repo.getInstance(ConcreteLocalSource.getInstance(requireContext()), ApiClient.getInstance(), requireContext()),mealID);
        if (isLocal){
            addBtn.setEnabled(false);
            addBtn.setVisibility(View.INVISIBLE);
            favBtn.setEnabled(false);
            favBtn.setVisibility(view.INVISIBLE);
            presenter.getSelectedMealLocal(mealID).observe(getViewLifecycleOwner(), new Observer<LocalFavMeal>() {
                @Override
                public void onChanged(LocalFavMeal localFavMeal) {
                    ArrayList<Ingredient> ingredient= presenter.getLocalIngredient(localFavMeal);
                    String resMealTitle=localFavMeal.getStrMeal();
                    String resMealInstructions=localFavMeal.getStrInstructions();
                    String resMealImg=localFavMeal.getStrMealThumb();

                    mealTitle.setText(resMealTitle);

                    mealIns.setText(resMealInstructions);
                    Glide.with(getContext())
                            .load(resMealImg)
                            .into(mealImage);
                    String youtubeLink = localFavMeal.getStrYoutube();
                   // String youtubeVideoId=getYoutubeVideoId(youtubeLink);
                     String youtubeVideoId=youtubeLink;

                    youtubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                        @Override
                        public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                            youTubePlayer.loadVideo(youtubeLink, 0);
                            youTubePlayer.pause();
                        }
                    });

                    mealsWeek=new LocalMealsWeek(mealID,resMealTitle,"",resMealInstructions,resMealImg,youtubeVideoId,localFavMeal.getStrIngredien1(),localFavMeal.getStrIngredien2(),localFavMeal.getStrIngredien3(),localFavMeal.getStrIngredien4(),localFavMeal.getStrIngredien5(),localFavMeal.getStrIngredien6(),localFavMeal.getStrIngredien7(),localFavMeal.getStrIngredien8(),localFavMeal.getStrIngredien9(),localFavMeal.getStrIngredien10(),localFavMeal.getStrIngredien11(),localFavMeal.getStrIngredien12(),localFavMeal.getStrIngredien13(),localFavMeal.getStrIngredien14(),localFavMeal.getStrIngredien15(), (String) localFavMeal.getStrIngredien16(), (String) localFavMeal.getStrIngredien17(), (String) localFavMeal.getStrIngredien18(), (String) localFavMeal.getStrIngredien19(), (String) localFavMeal.getStrIngredien20(),localFavMeal.getStrMeasure1(),localFavMeal.getStrMeasure2(),localFavMeal.getStrMeasure3(),localFavMeal.getStrMeasure4(),localFavMeal.getStrMeasure5(),localFavMeal.getStrMeasure6(),localFavMeal.getStrMeasure7(),localFavMeal.getStrMeasure8(),localFavMeal.getStrMeasure9(),localFavMeal.getStrMeasure10(),localFavMeal.getStrMeasure11(),localFavMeal.getStrMeasure12(),localFavMeal.getStrMeasure13(),localFavMeal.getStrMeasure14(),localFavMeal.getStrMeasure15(), (String) localFavMeal.getStrMeasure16(), (String) localFavMeal.getStrMeasure17(), (String) localFavMeal.getStrMeasure18(), (String) localFavMeal.getStrMeasure19(), (String) localFavMeal.getStrMeasure20());

                    adapter.setList(ingredient);

                }
            });
        }else {
        presenter.getSelectedMeal(mealID);
        presenter.getMeal();}
        mealTitle=view.findViewById(R.id.meal_det_name);
        mealIns=view.findViewById(R.id.det_instructions);
        mealImage=view.findViewById(R.id.det_image);

        mealRecyclerView = view.findViewById(R.id.ingredients_rec);
        mealRecyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mealRecyclerView.setLayoutManager(manager);
        adapter = new DetailsAdapter((ArrayList<Ingredient>) meal, requireContext() );
        mealRecyclerView.setAdapter(adapter);

        youtubePlayerView = view.findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youtubePlayerView);

        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMeal(localFavMeal);
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDailouge();
            }
        });

    }

    private void showDailouge() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.days_week);
        stDay=dialog.findViewById(R.id.saturday);
        sunDay=dialog.findViewById(R.id.sunday);
        monDay=dialog.findViewById(R.id.monday);
        tueDay=dialog.findViewById(R.id.tuesday);
        wedDay=dialog.findViewById(R.id.wednesday);
        thuDay=dialog.findViewById(R.id.thursday);
        friDay=dialog.findViewById(R.id.friday);

        stDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mealsWeek.setDay("stDay");

                presenter.addDayMeal(mealsWeek);



                Toast.makeText(getContext(), "added to calendar", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
        sunDay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mealsWeek.setDay("sunDay");
                presenter.addDayMeal(mealsWeek);


                Toast.makeText(getContext(), "added to calendar", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
        monDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mealsWeek.setDay("monDay");
                presenter.addDayMeal(mealsWeek);


                Toast.makeText(getContext(), "added to calendar", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
        tueDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mealsWeek.setDay("tueDay");
                presenter.addDayMeal(mealsWeek);


                Toast.makeText(getContext(), "added to calendar", Toast.LENGTH_SHORT).show();

                dialog.dismiss();

            }
        });
        wedDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mealsWeek.setDay("wedDay");
                presenter.addDayMeal(mealsWeek);

                Toast.makeText(getContext(), "added to calendar", Toast.LENGTH_SHORT).show();


                dialog.dismiss();

            }
        });
        thuDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mealsWeek.setDay("thuDay");
                presenter.addDayMeal(mealsWeek);


                Toast.makeText(getContext(), "added to calendar", Toast.LENGTH_SHORT).show();

                dialog.dismiss();

            }
        });
        friDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mealsWeek.setDay("friDay");
                presenter.addDayMeal(mealsWeek);


                Toast.makeText(getContext(), "added to calendar", Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);



    }

    @Override
    public void showData(List<SelectedMealsItem> meals, ArrayList<Ingredient> ingredientList) {
        SelectedMealsItem meal= meals.get(0);
        String resMealTitle=meal.getStrMeal();
        String resMealInstructions=meal.getStrInstructions();
        String resMealImg=meal.getStrMealThumb();

        mealTitle.setText(resMealTitle);

        mealIns.setText(resMealInstructions);
        Glide.with(getContext())
                .load(resMealImg)
                .into(mealImage);
        String youtubeLink = meals.get(0).getStrYoutube();
        String youtubeVideoId=getYoutubeVideoId(youtubeLink);
        youtubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(youtubeVideoId, 0);
                youTubePlayer.pause();
            }
        });

        mealsWeek=new LocalMealsWeek(mealID,resMealTitle,"",resMealInstructions,resMealImg,youtubeVideoId,meal.getStrIngredient1(),meal.getStrIngredient2(),meal.getStrIngredient3(),meal.getStrIngredient4(),meal.getStrIngredient5(),meal.getStrIngredient6(),meal.getStrIngredient7(),meal.getStrIngredient8(),meal.getStrIngredient9(),meal.getStrIngredient10(),meal.getStrIngredient11(),meal.getStrIngredient12(),meal.getStrIngredient13(),meal.getStrIngredient14(),meal.getStrIngredient15(), (String) meal.getStrIngredient16(), (String) meal.getStrIngredient17(), (String) meal.getStrIngredient18(), (String) meal.getStrIngredient19(), (String) meal.getStrIngredient20(),meal.getStrMeasure1(),meal.getStrMeasure2(),meal.getStrMeasure3(),meal.getStrMeasure4(),meal.getStrMeasure5(),meal.getStrMeasure6(),meal.getStrMeasure7(),meal.getStrMeasure8(),meal.getStrMeasure9(),meal.getStrMeasure10(),meal.getStrMeasure11(),meal.getStrMeasure12(),meal.getStrMeasure13(),meal.getStrMeasure14(),meal.getStrMeasure15(), (String) meal.getStrMeasure16(), (String) meal.getStrMeasure17(), (String) meal.getStrMeasure18(), (String) meal.getStrMeasure19(), (String) meal.getStrMeasure20());

        localFavMeal=new LocalFavMeal(mealID,resMealTitle,resMealInstructions,resMealImg,youtubeVideoId,meal.getStrIngredient1(),meal.getStrIngredient2(),meal.getStrIngredient3(),meal.getStrIngredient4(),meal.getStrIngredient5(),meal.getStrIngredient6(),meal.getStrIngredient7(),meal.getStrIngredient8(),meal.getStrIngredient9(),meal.getStrIngredient10(),meal.getStrIngredient11(),meal.getStrIngredient12(),meal.getStrIngredient13(),meal.getStrIngredient14(),meal.getStrIngredient15(), (String) meal.getStrIngredient16(), (String) meal.getStrIngredient17(), (String) meal.getStrIngredient18(), (String) meal.getStrIngredient19(), (String) meal.getStrIngredient20(),meal.getStrMeasure1(),meal.getStrMeasure2(),meal.getStrMeasure3(),meal.getStrMeasure4(),meal.getStrMeasure5(),meal.getStrMeasure6(),meal.getStrMeasure7(),meal.getStrMeasure8(),meal.getStrMeasure9(),meal.getStrMeasure10(),meal.getStrMeasure11(),meal.getStrMeasure12(),meal.getStrMeasure13(),meal.getStrMeasure14(),meal.getStrMeasure15(), (String) meal.getStrMeasure16(), (String) meal.getStrMeasure17(), (String) meal.getStrMeasure18(), (String) meal.getStrMeasure19(), (String) meal.getStrMeasure20());


            adapter.setList(ingredientList);

    }


    @Override
    public void addMeal(LocalFavMeal meal) {
        presenter.addMeal(meal);
        Toast.makeText(getContext(), "added to favourite", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void addDayMeal(LocalMealsWeek mealsWeek) {

    }

    private String getYoutubeVideoId(String youtubeLink) {
        String videoId = "";
        if (youtubeLink != null && youtubeLink.trim().length() > 0) {
            String[] split = youtubeLink.split("=");
            if (split.length > 1) {
                videoId = split[1];
            }
        }
        return videoId;
    }
    public void onDestroy() {
        super.onDestroy();
        if (youtubePlayerView != null) {
            youtubePlayerView.release();
        }

    }
}