package com.better.nutritiontherapy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewVitaminOpenActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vitamin_open);
        imageView=findViewById(R.id.img1);
        textView=findViewById(R.id.tx1);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String countryName=bundle.getString("name");
            showDetails(countryName);
        }
    }
    void showDetails(String countryNAme){
        if(countryNAme.equals("ভিটামিন এ")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.vit_a_source);
        }
        if(countryNAme.equals("ভিটামিন বি")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.vit_b);
        }if(countryNAme.equals("ভিটামিন সি")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.vitc);
        }if(countryNAme.equals("ভিটামিন ডি")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.vitamind);
        }if(countryNAme.equals("ভিটামিন ই")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.vitamine);
        }
        if(countryNAme.equals("ভিটামিন-কে")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.vitamink);
        }

        if(countryNAme.equals("আয়োডিনের কাজ")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.iodin);
        }

        if(countryNAme.equals("জিঙ্ক")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.zinc);
        }

        if(countryNAme.equals("ম্যাংগানিজ")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.mn);
        }


        if(countryNAme.equals("ক্রোমিয়াম")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.cr);
        }if(countryNAme.equals("ফ্লোরিন")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.fl);
        }if(countryNAme.equals("সেলেনিয়াম")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.sel);
        }if(countryNAme.equals("লোহা")){
            imageView.setImageResource(R.drawable.vitamins);
            textView.setText(R.string.loha);
        }
    }
}
