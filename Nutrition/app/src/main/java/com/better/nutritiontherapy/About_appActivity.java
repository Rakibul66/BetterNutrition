package com.better.nutritiontherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.widget.TextView;

import com.startapp.sdk.adsbase.StartAppAd;

public class About_appActivity extends AppCompatActivity {
 TextView copytext1,copytext2;
    private ClipboardManager myClipboard;
    private ClipData myClip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("অ্যাপ সম্পর্কে");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
//
//        copytext1=findViewById(R.id.copytext1id);
//        copytext2=findViewById(R.id.copytext2id);
//        copytext1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String text = copytext1.getText().toString();
//                myClip = ClipData.newPlainText("text", text);
//                myClipboard.setPrimaryClip(myClip);
//                Toast.makeText(getApplicationContext(), "Text Copied",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
    }
        @Override
        public void onBackPressed() {
            StartAppAd.onBackPressed(this);
            super.onBackPressed();
        }
    }