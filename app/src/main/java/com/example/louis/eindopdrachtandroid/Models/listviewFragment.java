package com.example.louis.eindopdrachtandroid.Models;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.louis.eindopdrachtandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class listviewFragment extends Fragment {


    public listviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listview, container, false);
    }


}
