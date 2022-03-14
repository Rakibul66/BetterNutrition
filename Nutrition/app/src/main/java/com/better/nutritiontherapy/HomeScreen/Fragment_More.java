package com.better.nutritiontherapy.HomeScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


import com.better.nutritiontherapy.ApiActivity;
import com.better.nutritiontherapy.DiseaseActivity;
import com.better.nutritiontherapy.HealthTipsActivity;
import com.better.nutritiontherapy.HomeActivity2;
import com.better.nutritiontherapy.MomchildActivity;
import com.better.nutritiontherapy.NewVitaminActivity;
import com.better.nutritiontherapy.R;
import com.better.nutritiontherapy.RogNirnoyActivity;
import com.better.nutritiontherapy.SignActivity;
import com.better.nutritiontherapy.VarioufoodActivity;
import com.better.nutritiontherapy.VesosActivity;

import com.better.nutritiontherapy.breathe.FiveSecondBreathActivity;
import com.better.nutritiontherapy.firstaidActivity;

import java.util.HashMap;

public class Fragment_More extends Fragment {

    //SliderLayout sliderLayout;
    HashMap<String, String> Hash_file_maps;
    View view;

    private CardView timeline, rognirnoy, vitamin, diet, primary, vit_min, foodcal, phy_story, healthtips, disease, bloodbank, Ayush, health2, book,recipe;

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_more, container, false);
        book = view.findViewById(R.id.book2);
        diet = view.findViewById(R.id.breathe);
        foodcal = view.findViewById(R.id.FoodCalorie);
        primary = view.findViewById(R.id.primaryid);
        timeline = view.findViewById(R.id.timeline);
        disease = view.findViewById(R.id.disease);
        health2 = view.findViewById(R.id.healthtips);
        vitamin = view.findViewById(R.id.addid);
        Ayush = view.findViewById(R.id.ayush);
        vit_min = view.findViewById(R.id.vit_minid);
        healthtips = view.findViewById(R.id.healthtips_id);
        book = view.findViewById(R.id.book2);
        rognirnoy = view.findViewById(R.id.rognirnoyid);




        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), HomeActivity2.class);
                startActivity(intent);
            }
        });
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), FiveSecondBreathActivity.class);
                startActivity(intent);
            }
        });
        rognirnoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RogNirnoyActivity.class);
                startActivity(intent);
            }
        });
        health2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), HealthTipsActivity.class);
                startActivity(intent);
            }
        });
        foodcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), ApiActivity.class);
                startActivity(intent);
            }
        });

        disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DiseaseActivity.class);
                startActivity(intent);
            }
        });


        Ayush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VesosActivity.class);
                startActivity(intent);
            }
        });


        healthtips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(getContext(), NewVitaminActivity.class);
                startActivity(p);
            }
        });
        primary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), MomchildActivity.class);
                startActivity(intent);
            }
        });


        vitamin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), firstaidActivity.class);
                startActivity(intent);
            }
        });

        vit_min.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), VarioufoodActivity.class);
                startActivity(intent);
            }
        });

        timeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SignActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }

}
