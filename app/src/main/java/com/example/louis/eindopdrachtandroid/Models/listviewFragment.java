package com.example.louis.eindopdrachtandroid.Models;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.louis.eindopdrachtandroid.Adapters.SpinnerAdapter;
import com.example.louis.eindopdrachtandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class listviewFragment extends Fragment {

    private ListView listView1;

    public listviewFragment()
    {
        // Required empty public constructor
        //url = url;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listview, container, false);


        List<String> Results =  new ArrayList<String>();

        Results.add("Jarno");
        Results.add("Louis");
        Results.add("Sander");
        Results.add("Bert");
        Results.add("Rick");
        Results.add("Bennie");
        Results.add("Bryan");
        Results.add("Robin");
        Results.add("Sam");
        Results.add("Jamie");
        Results.add("Sven");
        Results.add("Erwin");

        final SpinnerAdapter adapter = new SpinnerAdapter(getActivity(),android.R.layout.simple_list_item_1, Results);

        listView1 = (ListView) getView().findViewById(R.id.ListZoek);
        listView1.setAdapter(adapter);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {


                String selected = (String) listView1.getAdapter().getItem(arg2);


            }
        });

    }
}
