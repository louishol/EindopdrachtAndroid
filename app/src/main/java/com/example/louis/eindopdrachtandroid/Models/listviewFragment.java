package com.example.louis.eindopdrachtandroid.Models;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.louis.eindopdrachtandroid.Adapters.RestaurantAdapter;
import com.example.louis.eindopdrachtandroid.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class listviewFragment extends Fragment implements AsyncResponse {

    private OnItemSelectedListener listener;

    // Define the events that the fragment will use to communicate
    public interface OnItemSelectedListener {
        public void itemSelected(Restaurant restaurant);
    }


    Task task;
    TextView txt;
    ListView listView;
    public listviewFragment()
    {
        task = new Task();
        task.delegate = this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_listview, container, false);
        listView =  (ListView) rootView.findViewById(R.id.ListZoek);
        txt = (TextView) rootView.findViewById(R.id.txtResults);
        txt.setText("Bezig met zoeken....");
        Bundle b = getActivity().getIntent().getExtras();
        task.execute(b.getString("url"));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {

                final Restaurant restaurant = (Restaurant)listView.getItemAtPosition(position);

                listener.itemSelected(restaurant);

            }
        });


        return rootView;
    }


    public void processFinish(String output)
    {
        JSONArray results = null;
        ArrayList<Restaurant> Results = new ArrayList<Restaurant>();
        try {

            JSONObject obj = new JSONObject(output);
            results= obj.getJSONArray("results");

        } catch (Throwable t) {

        }
        if(results != null)
        {
            for (int i = 0; i < results.length(); i++) {
                try
                {
                    JSONObject row = results.getJSONObject(i);
                    JSONObject geo = row.getJSONObject("geolocation");

                    double lat =  geo.getDouble("latitude");
                    double lng = geo.getDouble("longitude");

                    Results.add(new Restaurant(row.getInt("id"), row.getString("name"), lat, lng));

                } catch (Throwable t) {

                }

            }
        }
        txt.setText("Zoek resultaten");
        final RestaurantAdapter adapter = new RestaurantAdapter(getActivity(),R.layout.listviewitem, Results);
        listView.setAdapter(adapter);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }

        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }
}
