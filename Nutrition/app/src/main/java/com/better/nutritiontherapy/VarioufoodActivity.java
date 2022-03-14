package com.better.nutritiontherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.MobileAds;

public class VarioufoodActivity extends AppCompatActivity {
    CardView c1,c2,c3,c4;
    //private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varioufood);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("বিভাগ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        c1=findViewById(R.id.vegetarianid);
        c2=findViewById(R.id.non_vegetarianid);
        c4=findViewById(R.id.mixid);
        c3=findViewById(R.id.oilid);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),VegActivity.class);
                startActivity(intent1);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(getApplicationContext(),NonvegActivity.class);
                startActivity(intent2);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(getApplicationContext(),FatsoilActivity.class);
                startActivity(intent3);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(getApplicationContext(),Nutrient_sourceActivity.class);
                startActivity(intent4);
            }
        });
    }
}
