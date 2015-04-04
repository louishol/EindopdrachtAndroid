package com.example.louis.eindopdrachtandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.louis.eindopdrachtandroid.Models.AsyncResponse;
import com.example.louis.eindopdrachtandroid.Models.Restaurant;
import com.example.louis.eindopdrachtandroid.Models.detailFragment;
import com.example.louis.eindopdrachtandroid.Models.listviewFragment;


public class ResultActivity extends ActionBarActivity implements listviewFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void itemSelected(Restaurant restaurant)
    {
        showDialog(restaurant);
    }

    private void showDialog(final Restaurant restaurant) {
        new AlertDialog.Builder(this)
                .setTitle("Maak een keuze")
                .setMessage("Details laten zien of navigeren?")
                .setPositiveButton("Details", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                       showDetails(restaurant.id);
                    }
                })
                .setNegativeButton("Navigeren", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//
                        startNavigationActivity(restaurant.lat, restaurant.lng);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void showDetails(int id) {

        detailFragment fragmentdetails = (detailFragment) getFragmentManager().findFragmentById(R.id.fragDetails);
        if (fragmentdetails == null) {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("id", Integer.toString(id));
            startActivity(intent);
        }
        else
        {
            //displayFrag.updateContent(position, title, description);
            fragmentdetails.updateContent(id);
        }

    }
    private void startNavigationActivity(double lat, double lng) {

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q="+lat + "," + lng));
        startActivity(i);

    }


}
