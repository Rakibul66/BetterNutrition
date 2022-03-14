package com.better.nutritiontherapy;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Spinner spinner;
    private DatabaseReference reference;
    private ArrayList<BooksModel> list;
    private String category = "নিউট্রিশন";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        gettingLayoutIDs();
        categorySelector();

        showBooks(category);
    }

    private void showBooks(String cate){
        reference.child(cate).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    list.add(ds.getValue(BooksModel.class));
                }

                BookAdapter adapter = new BookAdapter(list, HomeActivity2.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void categorySelector(){

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                category = spinner.getSelectedItem().toString();
                showBooks(category);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}

        });
    }

    private void gettingLayoutIDs(){
        recyclerView = findViewById(R.id.recycler_view);
        spinner = findViewById(R.id.spinner);
        reference = FirebaseDatabase.getInstance().getReference().child("Book App");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }
}
