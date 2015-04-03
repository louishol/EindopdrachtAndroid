package com.example.louis.eindopdrachtandroid.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.louis.eindopdrachtandroid.Models.Restaurant;
import com.example.louis.eindopdrachtandroid.R;

import java.util.List;

/**
 * Created by Louis on 2-4-2015.
 */
public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    Context context;
    int layoutResourceId;
    List<Restaurant> list = null;

    public RestaurantAdapter(Context context, int layoutResourceId, List<Restaurant> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.list = data;
    }

    @Override
    public void remove(Restaurant object) {
        list.remove(object);
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Holder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new Holder();
            holder.title = (TextView)row.findViewById(R.id.txtTitle);
            row.setTag(holder);
        }
        else
        {
            holder = (Holder)row.getTag();
        }

        Restaurant information = list.get(position);
        holder.title.setText(information.title);

        return row;
    }

    static class Holder
    {
        TextView title;
    }
}