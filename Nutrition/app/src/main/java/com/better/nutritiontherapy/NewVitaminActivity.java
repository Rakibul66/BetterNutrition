package com.better.nutritiontherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewVitaminActivity extends AppCompatActivity implements View.OnClickListener{
    private Button one,two,three,four,five,six,seven,eigt,nine,ten,eleven,twelve,thirteen;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vitamin);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("ভিটামিন ও খনিজ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        one=findViewById(R.id.one_v);
        two=findViewById(R.id.two_v);
        three=findViewById(R.id.three_v);
        four=findViewById(R.id.four_v);
        five=findViewById(R.id.fv_v);
        six=findViewById(R.id.sx_v);
        seven=findViewById(R.id.svn_v);
        eigt=findViewById(R.id.eght_v);
        nine=findViewById(R.id.nine_v);
        ten=findViewById(R.id.tenn_v);
        eleven=findViewById(R.id.elven_v);
        twelve=findViewById(R.id.twoelve_v);
        thirteen=findViewById(R.id.thirteena_v);
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

        if(v.getId()==R.id.one_v){
            intent=new Intent(NewVitaminActivity.this,NewVitaminOpenActivity.class);
            intent.putExtra("name","ভিটামিন এ");
            startActivity(intent);}

        if(v.getId()==R.id.two_v){
            intent=new Intent(NewVitaminActivity.this,NewVitaminOpenActivity.class);
            intent.putExtra("name","ভিটামিন বি");
            startActivity(intent);}
        if(v.getId()==R.id.three_v) {
            intent = new Intent(NewVitaminActivity.this, NewVitaminOpenActivity.class);
            intent.putExtra("name", "ভিটামিন সি");
            startActivity(intent);}
        if (v.getId() == R.id.four_v) {
            intent = new Intent(NewVitaminActivity.this,NewVitaminOpenActivity.class);
            intent.putExtra("name", "ভিটামিন ডি");
            startActivity(intent);
        }

        if (v.getId() == R.id.fv_v) {
            intent = new Intent(NewVitaminActivity.this, NewVitaminOpenActivity.class);
            intent.putExtra("name", "ভিটামিন ই");
            startActivity(intent);
        }
        if (v.getId() == R.id.sx_v) {
            intent = new Intent(NewVitaminActivity.this, NewVitaminOpenActivity.class);
            intent.putExtra("name", "ভিটামিন-কে");
            startActivity(intent);}

        if (v.getId() == R.id.svn_v) {
            intent = new Intent(NewVitaminActivity.this, NewVitaminOpenActivity.class);
            intent.putExtra("name", "আয়োডিনের কাজ");
            startActivity(intent);
        }

        if (v.getId() == R.id.eght_v) {
            intent = new Intent(NewVitaminActivity.this, NewVitaminOpenActivity.class);
            intent.putExtra("name", "জিঙ্ক");
            startActivity(intent);
        }
        if (v.getId() == R.id.nine_v) {
            intent = new Intent(NewVitaminActivity.this, NewVitaminOpenActivity.class);
            intent.putExtra("name", "ম্যাংগানিজ");
            startActivity(intent);
        }
        if (v.getId() == R.id.tenn_v) {
            intent = new Intent(NewVitaminActivity.this, NewVitaminOpenActivity.class);
            intent.putExtra("name", "ক্রোমিয়াম");
            startActivity(intent);
        }
        if (v.getId() == R.id.elven_v) {
            intent = new Intent(NewVitaminActivity.this, NewVitaminOpenActivity.class);
            intent.putExtra("name", "ফ্লোরিন");
            startActivity(intent);
        }
        if (v.getId() == R.id.twoelve_v) {
            intent = new Intent(NewVitaminActivity.this, NewVitaminOpenActivity.class);
            intent.putExtra("name", "সেলেনিয়াম");
            startActivity(intent);
        }
        if (v.getId() == R.id.thirteena_v) {
            intent = new Intent(NewVitaminActivity.this,NewVitaminOpenActivity.class);
            intent.putExtra("name", "লোহা");
            startActivity(intent);
        }
    }
}
