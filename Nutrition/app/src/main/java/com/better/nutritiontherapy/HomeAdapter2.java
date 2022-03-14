package com.better.nutritiontherapy;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter2 extends RecyclerView.Adapter<HomeAdapter2.ViewHolder>{

    Activity activity;
    ArrayList<PostModel2> list;

    public HomeAdapter2(Activity activity, ArrayList<PostModel2> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Blog App").child("Users").child(list.get(position).getUid());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
              //  Picasso.get().load(snapshot.child("picture").getValue(String.class)).into(holder.pp);
                holder.name.setText(snapshot.child("name").getValue(String.class));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Picasso.get().load(list.get(position).getPicture()).into(holder.bp);
        holder.title.setText(list.get(position).getTitle());
        holder.category.setText(list.get(position).getCategory());
        holder.blog.setText(list.get(position).getBlog());

        holder.date.setText(list.get(position).getDate());




        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Blog App").child("Posts").child(list.get(position).getCategory())
                        .child(list.get(position).getId());
                DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("Blog App").child("Users Post").child(list.get(position).getUid())
                        .child(list.get(position).getId());


                Intent intent = new Intent(activity, DetailsActivity.class);
                intent.putExtra("id", list.get(position).getId());
                intent.putExtra("uid", list.get(position).getUid());
                intent.putExtra("cate", list.get(position).getCategory());
                activity.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView pp, bp, likeIco;
        TextView name, title, blog, likes, views, category, date;
        LinearLayout like, layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.name);

            bp = itemView.findViewById(R.id.blog_image);
            title = itemView.findViewById(R.id.blog_title);
            blog = itemView.findViewById(R.id.description);

            layout = itemView.findViewById(R.id.post_layout);
            category = itemView.findViewById(R.id.category);
            date = itemView.findViewById(R.id.date);
        }
    }
}
