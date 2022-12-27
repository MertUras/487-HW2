package com.example.hw2_merturas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter
{

    Context context;
    String[] teamNames;
    int[] teamIcons;

    public ItemAdapter(Context context, String[] teamNames, int[] teamIcons) {
        this.context = context;
        this.teamNames = teamNames;
        this.teamIcons = teamIcons;
    }

    @Override
    public int getCount() {
        return teamNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.team_layout,viewGroup,false);
        ImageView imageView=view.findViewById(R.id.teamIcon);
        TextView textView=view.findViewById(R.id.tv);

        imageView.setImageResource(teamIcons[i]);
        textView.setText(teamNames[i]);
        return view;
    }
}
