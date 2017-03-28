package com.erik5991.bioscoopapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Erik on 27-3-2017.
 */

public class MenuAdapter extends BaseAdapter {
    private final String TAG = this.getClass().getSimpleName();

    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<String> menuArrayList;

    public MenuAdapter(Context mContext, LayoutInflater mInflator, ArrayList<String> menuArrayList) {
        this.mContext = mContext;
        this.mInflator = mInflator;
        this.menuArrayList = menuArrayList;
    }

    @Override
    public int getCount() {
        int size = menuArrayList.size();
        Log.i(TAG, "getCount() =  " + size);
        return size;
    }

    @Override
    public Object getItem(int position) {
        Log.i(TAG, "getItem() at " + position);
        return menuArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i(TAG, "getView at " + position);

        ViewHolder viewHolder;
        if (convertView == null) {

            Log.i(TAG, "convertView is NULL - nieuwe maken");

            // Koppel de convertView aan de layout van onze eigen row
            convertView = mInflator.inflate(R.layout.list_menu_row, null);

            // Maak een ViewHolder en koppel de schermvelden aan de velden uit onze eigen row.
            viewHolder = new ViewHolder();
            viewHolder.textViewLocatie = (TextView) convertView.findViewById(R.id.locatieText);
            //viewHolder.textViewSpecsTag = (TextView) convertView.findViewById(R.id.rowSpecsTag);
            //  viewHolder.textViewSummary = (TextView) convertView.findViewById(R.id.rowSummary);
            // viewHolder.imageView = (ImageView) convertView.findViewById(R.id.smallImageView);

            // Sla de viewholder op in de convertView
            convertView.setTag(viewHolder);

        } else {
            Log.i(TAG, "convertView BESTOND AL - hergebruik");
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String string = menuArrayList.get(position);
       // viewHolder.textViewLocatie.setText(R.strin);
        //viewHolder.textViewSpecsTag.setText(locatie.getSpecsTag());
        //   viewHolder.textViewSummary.setText(locatie.getSummary());
        //   new ImageLoader(viewHolder.imageView).execute(locatie.getGoogleMaps());

        return convertView;
    }

    private static class ViewHolder {
        public TextView textViewLocatie;
        public TextView textViewSpecsTag;
        public TextView textViewSummary;
        public ImageView imageView;
    }


}