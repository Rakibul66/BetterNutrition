package com.better.nutritiontherapy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private ImageView pp, image;
    private TextView name, cate, date, title, blog;
    String id, uid, cat, views;
    int v, view;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        uid = intent.getStringExtra("uid");
        cat = intent.getStringExtra("cate");

        gettingLayoutIDs();
        gettingPostDetails();
    }

    private void gettingPostDetails(){
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PostModel post;
                post = snapshot.getValue(PostModel.class);
                try {
                    cate.setText(post.getCategory());
                    date.setText(post.getDate());
                    title.setText(post.getTitle());
                    blog.setText(post.getBlog());
                    Picasso.get().load(post.getPicture()).into(image);
                }catch (Exception e){}

                DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("Blog App").child("Users").child(uid);
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        UserDetails user;
                        user = snapshot.getValue(UserDetails.class);
                        Picasso.get().load(user.getPicture()).into(pp);
                        name.setText(user.getName());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void gettingLayoutIDs(){
        pp = findViewById(R.id.profile_picture);
        name = findViewById(R.id.name);
        cate = findViewById(R.id.category);
        date = findViewById(R.id.date);
        title = findViewById(R.id.blog_title);
        blog = findViewById(R.id.description);
        image = findViewById(R.id.blog_image);

        ref = FirebaseDatabase.getInstance().getReference().child("Blog App").child("Posts").child(cat).child(id);
    }
}
