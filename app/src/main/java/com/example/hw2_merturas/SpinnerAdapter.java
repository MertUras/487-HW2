package com.example.hw2_merturas;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<Teams> {
    private Context context;
    private int layoutResourceId;
    private LayoutInflater inflator;
    private ArrayList<Teams> TeamsList;


    private boolean flag=false;

    public SpinnerAdapter(@NonNull Context context, int teamspinner,ArrayList<Teams> teamsArrayList) {

        super(context, teamspinner,teamsArrayList);
        this.context=context;
        this.layoutResourceId=teamspinner;
        TeamsList=teamsArrayList;
    }
    @Override
    public View getDropDownView(int position,  View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position,  View convertView,  ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null){
            inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflator.inflate(layoutResourceId,parent,false);
        }

        ConstraintLayout itemLayout = rowView.findViewById(R.id.itemLayout);
        TextView tv_main = rowView.findViewById(R.id.tvItemMain);
        ImageView leftPic = rowView.findViewById(R.id.imgItemleftPic);

        if(flag)
            itemLayout.setBackgroundColor(Color.MAGENTA);
        else
            itemLayout.setBackgroundColor(Color.GREEN);

        tv_main.setText(TeamsList.get(position).getName());
        leftPic.setImageResource(TeamsList.get(position).getImgId());

        return rowView;
    }
}
