package com.example.projectandroid.Activity.Adaptor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectandroid.Activity.Domain.FoodDomain;
import com.example.projectandroid.Activity.ShowDetailActivity;
import com.example.projectandroid.R;

import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.Viewholder> {
    ArrayList<FoodDomain> popularFood;

    public PopularAdaptor(ArrayList<FoodDomain> categoryDomains) {
        this.popularFood = categoryDomains;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdaptor.Viewholder holder, @SuppressLint("RecyclerView") int position) {
    holder.title.setText(popularFood.get(position).getTitle());
    holder.fee.setText(String.valueOf(popularFood.get(position).getFee()));


    int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(popularFood.get(position).getPic(), "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object",popularFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularFood.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
    TextView title,fee;
    ImageView pic;
    TextView addBtn;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
        title = itemView.findViewById(R.id.title);
        fee = itemView.findViewById(R.id.fee);
        pic = itemView.findViewById(R.id.pic);
        addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
