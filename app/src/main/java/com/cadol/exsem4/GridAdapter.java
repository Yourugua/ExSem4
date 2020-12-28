package com.cadol.exsem4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import java.util.ArrayList;


public class GridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> arrayList;

    public GridAdapter ( Context context , ArrayList<String> arrayList){
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
           LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
           convertView = layoutInflater.inflate(R.layout.item_grid, parent, false);
        }

        TextView tituloTv = (TextView) convertView.findViewById(R.id.iv_tv_Titulo);
        tituloTv.setText(arrayList.get(position));
        return convertView;
    }

}
