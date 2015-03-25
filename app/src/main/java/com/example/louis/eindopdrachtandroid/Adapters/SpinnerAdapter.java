package com.example.louis.eindopdrachtandroid.Adapters;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Louis on 25-3-2015.
 */
public class SpinnerAdapter extends BaseAdapter {

    private List<Integer> spinnerList = new ArrayList<Integer>();

    public int getCount() {
        return spinnerList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public int getColor(int position) {
        return spinnerList.get(position);
    }
}
