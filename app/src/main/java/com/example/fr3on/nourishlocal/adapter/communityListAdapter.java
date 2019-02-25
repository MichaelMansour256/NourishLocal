package com.example.fr3on.nourishlocal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fr3on.nourishlocal.R;
import com.example.fr3on.nourishlocal.model.community;

import java.util.ArrayList;

public class communityListAdapter extends BaseAdapter {
    ArrayList <community>dataList;
    Context context;


    public communityListAdapter (ArrayList<community>list,Context c){
        dataList=list;
         context =c;

    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.community_list_item,parent,false);
        ImageView ImageView = rowView.findViewById(R.id.imageView);
        TextView titleTextView = rowView.findViewById(R.id.titleTextView);
        ImageView.setImageResource(dataList.get(position).getImageReference());
        titleTextView.setText(dataList.get(position).getName());
        return rowView;
    }
}
