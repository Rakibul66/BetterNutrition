package com.better.nutritiontherapy.HomeScreen;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.better.nutritiontherapy.HomeAdapter2;
import com.better.nutritiontherapy.PostModel2;
import com.better.nutritiontherapy.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Fragment_blog extends Fragment {
    View view;

    private ImageView profile;
    private TextView createPost, all, one, two, three, four, five;
    private RecyclerView recyclerView;
    private DatabaseReference postRef;
    private ArrayList<PostModel2> list;
    private Activity activity;
    private LinearLayout notFound;
    private Dialog dialog;
    private ImageView back;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_blog,container,false);




        gettingLayoutIDs();
        getPosts();
        onClickListeners();
        activity = getActivity();



//        dialog.setContentView(R.layout.progress_dialog);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.setCancelable(false);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();
        return view;
    }


    private void onClickListeners(){
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setBackgroundResource(R.drawable.selected);
                one.setBackgroundResource(R.drawable.unsilectec);
                two.setBackgroundResource(R.drawable.unsilectec);
                three.setBackgroundResource(R.drawable.unsilectec);
                four.setBackgroundResource(R.drawable.unsilectec);
                five.setBackgroundResource(R.drawable.unsilectec);
                getPosts();
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setBackgroundResource(R.drawable.unsilectec);
                one.setBackgroundResource(R.drawable.selected);
                two.setBackgroundResource(R.drawable.unsilectec);
                three.setBackgroundResource(R.drawable.unsilectec);
                four.setBackgroundResource(R.drawable.unsilectec);
                five.setBackgroundResource(R.drawable.unsilectec);

                getCategorizedPosts(one.getText().toString());
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setBackgroundResource(R.drawable.unsilectec);
                one.setBackgroundResource(R.drawable.unsilectec);
                two.setBackgroundResource(R.drawable.selected);
                three.setBackgroundResource(R.drawable.unsilectec);
                four.setBackgroundResource(R.drawable.unsilectec);
                five.setBackgroundResource(R.drawable.unsilectec);

                getCategorizedPosts(two.getText().toString());
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setBackgroundResource(R.drawable.unsilectec);
                one.setBackgroundResource(R.drawable.unsilectec);
                two.setBackgroundResource(R.drawable.unsilectec);
                three.setBackgroundResource(R.drawable.selected);
                four.setBackgroundResource(R.drawable.unsilectec);
                five.setBackgroundResource(R.drawable.unsilectec);

                getCategorizedPosts(three.getText().toString());
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setBackgroundResource(R.drawable.unsilectec);
                one.setBackgroundResource(R.drawable.unsilectec);
                two.setBackgroundResource(R.drawable.unsilectec);
                three.setBackgroundResource(R.drawable.unsilectec);
                four.setBackgroundResource(R.drawable.selected);
                five.setBackgroundResource(R.drawable.unsilectec);

                getCategorizedPosts(four.getText().toString());
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setBackgroundResource(R.drawable.unsilectec);
                one.setBackgroundResource(R.drawable.unsilectec);
                two.setBackgroundResource(R.drawable.unsilectec);
                three.setBackgroundResource(R.drawable.unsilectec);
                four.setBackgroundResource(R.drawable.unsilectec);
                five.setBackgroundResource(R.drawable.selected);

                getCategorizedPosts(five.getText().toString());
            }
        });
    }

    private void getCategorizedPosts(String cate){
        DatabaseReference postRef = FirebaseDatabase.getInstance().getReference().child("Blog App").child("Posts").child(cate);
        postRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot ds: snapshot.getChildren()){
                    list.add(ds.getValue(PostModel2.class));
                }

                Collections.sort(list, new Comparator<PostModel2>() {
                    @Override
                    public int compare(PostModel2 a, PostModel2 b) {
                        return Long.compare(b.getTime(), a.getTime());
                    }
                });

                HomeAdapter2 adapter = new HomeAdapter2(activity, list);

                if (adapter.getItemCount() > 0){
                   // dialog.dismiss();
                    notFound.setVisibility(View.GONE);
                }
                else {
                    notFound.setVisibility(View.VISIBLE);
                    //dialog.dismiss();
                }
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void getPosts(){
        postRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dss: snapshot.getChildren()){
                    for (DataSnapshot ds: dss.getChildren()){
                        list.add(ds.getValue(PostModel2.class));
                    }
                }

                Collections.sort(list, new Comparator<PostModel2>() {
                    @Override
                    public int compare(PostModel2 a, PostModel2 b) {
                        return Long.compare(b.getTime(), a.getTime());
                    }
                });

                HomeAdapter2 adapter = new HomeAdapter2(activity, list);

                if (adapter.getItemCount() > 0){
                   // dialog.dismiss();
                    notFound.setVisibility(View.GONE);
                }
                else {
                    notFound.setVisibility(View.VISIBLE);
                   // dialog.dismiss();
                }
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void gettingLayoutIDs(){

        all = view.findViewById(R.id.all);
        one = view.findViewById(R.id.cone);
        two = view.findViewById(R.id.ctwo);
        three = view.findViewById(R.id.cthree);
        four = view.findViewById(R.id.cfour);
        five = view.findViewById(R.id.cfive);
        notFound = view.findViewById(R.id.not_found);

        //dialog = new Dialog(getContext());

        recyclerView = view.findViewById(R.id.home_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        postRef = FirebaseDatabase.getInstance().getReference().child("Blog App").child("Posts");


    }

}
