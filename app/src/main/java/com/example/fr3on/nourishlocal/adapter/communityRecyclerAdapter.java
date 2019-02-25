package com.example.fr3on.nourishlocal.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fr3on.nourishlocal.MainActivity;
import com.example.fr3on.nourishlocal.R;
import com.example.fr3on.nourishlocal.model.community;

import java.util.ArrayList;

public class communityRecyclerAdapter extends RecyclerView.Adapter {
    ArrayList<community> dataList;
    Context context;
    public communityRecyclerAdapter(ArrayList<community> list ,Context context){

        dataList=list;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detailes,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((  ViewHolder) holder).titleTextView.setText(dataList.get(position).getName());
        ((  ViewHolder) holder).imageView.setImageResource(dataList.get(position).getImageReference());
        final int index = holder.getAdapterPosition();
        ((ViewHolder)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).openDetailes(dataList.get(index));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView titleTextView;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            titleTextView = itemView.findViewById(R.id.titleTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
