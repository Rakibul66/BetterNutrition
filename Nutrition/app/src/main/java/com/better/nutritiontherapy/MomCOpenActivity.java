package com.better.nutritiontherapy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MomCOpenActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mom_c_open);
        imageView=findViewById(R.id.img1);
        textView=findViewById(R.id.tx1);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String countryName=bundle.getString("name");
            showDetails(countryName);
        }
    }
    void showDetails(String countryNAme){
        if(countryNAme.equals("নবজাতক শিশুকে")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.babytips);
        }
        if(countryNAme.equals("গর্ভকালীন পরিচর্যা")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.two_text);
        }if(countryNAme.equals("গর্ভবতী মা ও শিশুর পুষ্টি উপাদান")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.three_text);
        }if(countryNAme.equals("মায়ের দুধ শিশুর জীবনধারণ")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.four_text);
        }if(countryNAme.equals("শিশুর লালন পালন ও পরিচর্যা")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.five_text);
        }
        if(countryNAme.equals("বয়স মানানসই খাবার")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.six_txt);
        }

        if(countryNAme.equals("সদ্যজাত শিশুর যত্ন")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.seven_text);
        }

        if(countryNAme.equals("শিশুরা মেদবহুল হয়")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.eight_text);
        }

        if(countryNAme.equals("শিশুদের ওপর সেলফোনের ক্ষতিকারক প্রভাব")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.nin_text);
        }


        if(countryNAme.equals("শিশুর কাছে মাতৃদুগ্ধের গুরুত্ব??")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.ten_text);
        }if(countryNAme.equals("অটিজমের প্রাকৃতিক বিকল্প চিকিৎসা")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.elven_text);
        }if(countryNAme.equals("শিশু এবং তাদের খাদ্যাভ্যাস")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.twoeleven_text);
        }if(countryNAme.equals("শিশুদের ঘুমের ব্যাপারে")){
            imageView.setImageResource(R.drawable.mother);
            textView.setText(R.string.thirteen_text);
        }
    }}

