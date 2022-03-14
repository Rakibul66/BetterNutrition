package com.better.nutritiontherapy;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Details extends AppCompatActivity {
    TextView storyContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("কৌশল");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        storyContent = findViewById(R.id.contentOfStory);
        Intent i = getIntent();
        String title = i.getStringExtra("titleOfStory");
        String content = i.getStringExtra("contentOfStory");

//        // set the appbar title as Story title
//        getSupportActionBar().setTitle(title);

        // set content of the story to textview
        storyContent.setText(content);
        storyContent.setMovementMethod(new ScrollingMovementMethod());

        // enable back button to main activity or recyclerview
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
}
