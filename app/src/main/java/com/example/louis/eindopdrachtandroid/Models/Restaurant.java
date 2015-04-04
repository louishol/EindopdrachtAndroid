package com.example.louis.eindopdrachtandroid.Models;

import android.util.Log;

/**
 * Created by Louis on 2-4-2015.
 */
public class Restaurant {

    public int id;
    public String title;
    public double lng;
    public double lat;
    public Restaurant(){
        super();
    }

    public Restaurant(int id, String title, double lat, double lng) {

        this.id = id;
        this.title = title;
        this.lng = lng;
        this.lat = lat;
    }
}

