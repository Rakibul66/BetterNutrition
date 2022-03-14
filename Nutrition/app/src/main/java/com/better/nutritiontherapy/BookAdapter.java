package com.better.nutritiontherapy;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{

    ArrayList<BooksModel> list;
    Activity activity;

    public BookAdapter(ArrayList<BooksModel> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.books_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Picasso.get().load(list.get(position).getCover()).into(holder.cover);
        holder.name.setText(list.get(position).getName());
        holder.category.setText(list.get(position).getCategory());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ViewBookActivity.class);
                intent.putExtra("url", list.get(position).getPdf());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cover;
        TextView name, category;
        RelativeLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cover = itemView.findViewById(R.id.cover);
            name = itemView.findViewById(R.id.book_name);
            category = itemView.findViewById(R.id.book_category);
            layout = itemView.findViewById(R.id.book_layout);
        }
    }
}
