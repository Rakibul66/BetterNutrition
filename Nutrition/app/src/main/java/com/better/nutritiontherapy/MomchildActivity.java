package com.better.nutritiontherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MomchildActivity extends AppCompatActivity implements View.OnClickListener{
    private Button one,two,three,four,five,six,seven,eigt,nine,ten,eleven,twelve,thirteen;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_momchild);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("মা ও শিশু");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        one=findViewById(R.id.one);
        two=findViewById(R.id.two_id);
        three=findViewById(R.id.three_three);
        four=findViewById(R.id.four_id);
        five=findViewById(R.id.fv_id);
        six=findViewById(R.id.sx_id);
        seven=findViewById(R.id.svn_id);
        eigt=findViewById(R.id.eght_id);
        nine=findViewById(R.id.nine_id);
        ten=findViewById(R.id.tenn_id);
        eleven=findViewById(R.id.elven_id);
        twelve=findViewById(R.id.twoelve_id);
        thirteen=findViewById(R.id.thirteena_id);
//
        one.setOnClickListener(this);

        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);

        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);

        eigt.setOnClickListener(this);
        nine.setOnClickListener(this);
        ten.setOnClickListener(this);

        eleven.setOnClickListener(this);
        twelve.setOnClickListener(this);
        thirteen.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.one){
            intent=new Intent(MomchildActivity.this,MomCOpenActivity.class);
            intent.putExtra("name","নবজাতক শিশুকে");
            startActivity(intent);}

        if(v.getId()==R.id.two_id){
            intent=new Intent(MomchildActivity.this,MomCOpenActivity.class);
            intent.putExtra("name","গর্ভকালীন পরিচর্যা");
            startActivity(intent);}
        if(v.getId()==R.id.three_three) {
            intent = new Intent(MomchildActivity.this, MomCOpenActivity.class);
            intent.putExtra("name", "গর্ভবতী মা ও শিশুর পুষ্টি উপাদান");
            startActivity(intent);}
            if (v.getId() == R.id.four_id) {
                intent = new Intent(MomchildActivity.this, MomCOpenActivity.class);
                intent.putExtra("name", "মায়ের দুধ শিশুর জীবনধারণ");
                startActivity(intent);
            }

            if (v.getId() == R.id.fv_id) {
                intent = new Intent(MomchildActivity.this, MomCOpenActivity.class);
                intent.putExtra("name", "শিশুর লালন পালন ও পরিচর্যা");
                startActivity(intent);
            }
            if (v.getId() == R.id.sx_id) {
                intent = new Intent(MomchildActivity.this, MomCOpenActivity.class);
                intent.putExtra("name", "বয়স মানানসই খাবার");
                startActivity(intent);}

                if (v.getId() == R.id.svn_id) {
                    intent = new Intent(MomchildActivity.this, MomCOpenActivity.class);
                    intent.putExtra("name", "সদ্যজাত শিশুর যত্ন");
                    startActivity(intent);
                }

                if (v.getId() == R.id.eght_id) {
                    intent = new Intent(MomchildActivity.this, MomCOpenActivity.class);
                    intent.putExtra("name", "শিশুরা মেদবহুল হয়");
                    startActivity(intent);
                }
                if (v.getId() == R.id.nine_id) {
                    intent = new Intent(MomchildActivity.this, MomCOpenActivity.class);
                    intent.putExtra("name", "শিশুদের ওপর সেলফোনের ক্ষতিকারক প্রভাব");
                    startActivity(intent);
                }
        if (v.getId() == R.id.tenn_id) {
            intent = new Intent(MomchildActivity.this, MomCOpenActivity.class);
            intent.putExtra("name", "শিশুর কাছে মাতৃদুগ্ধের গুরুত্ব??");
            startActivity(intent);
        }
        if (v.getId() == R.id.elven_id) {
            intent = new Intent(MomchildActivity.this, MomCOpenActivity.class);
            intent.putExtra("name", "অটিজমের প্রাকৃতিক বিকল্প চিকিৎসা");
            startActivity(intent);
        }
        if (v.getId() == R.id.twoelve_id) {
            intent = new Intent(MomchildActivity.this, MomCOpenActivity.class);
            intent.putExtra("name", "শিশু এবং তাদের খাদ্যাভ্যাস");
            startActivity(intent);
        }
        if (v.getId() == R.id.thirteena_id) {
            intent = new Intent(MomchildActivity.this, MomCOpenActivity.class);
            intent.putExtra("name", "শিশুদের ঘুমের ব্যাপারে");
            startActivity(intent);
        }
            }
        }
