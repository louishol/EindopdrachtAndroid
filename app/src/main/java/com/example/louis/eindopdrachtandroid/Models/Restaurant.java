package com.example.louis.eindopdrachtandroid.Models;

import android.util.Log;

/**
 * Created by Louis on 2-4-2015.
 */
public class Restaurant {

    public int id;
    public String title;
    double lng;
    double lat;
    public Restaurant(){
        super();
    }

    public Restaurant(int id, String title, double lat, double lng) {

        Log.d("LALALA", "Dit is de lat " + lat);
        this.id = id;
        this.title = title;
        this.lng = lng;
        this.lat = lat;
    }
}

