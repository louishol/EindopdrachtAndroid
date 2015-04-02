package com.example.louis.eindopdrachtandroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getApiURI();
    }



    private String getApiURI()
    {

        String url = "https://api.eet.nu/venues?";

        Spinner mySpinner;

        List<String> Categories =  new ArrayList<String>();
        Categories.add("Alle categorien");
        Categories.add("African");
        Categories.add("Asian");
        Categories.add("Australian");
        Categories.add("Balkan");
        Categories.add("BBQ");
        Categories.add("Bistro");
        Categories.add("Chinese");
        Categories.add("Chinese-indian");
        Categories.add("Dutch");
        Categories.add("East-european");
        Categories.add("Eatery");
        Categories.add("Egyptian");
        Categories.add("English");
        Categories.add("Fish");
        Categories.add("Fondue");
        Categories.add("Food-vendor");
        Categories.add("French");
        Categories.add("Fusion");
        Categories.add("Greek");
        Categories.add("Grill");
        Categories.add("Ice-cream-parlor");
        Categories.add("Indian");
        Categories.add("Indonesian");
        Categories.add("International");
        Categories.add("Israeli");
        Categories.add("Italian");
        Categories.add("Japanese");
        Categories.add("Kebab");
        Categories.add("Kosher-depricated");
        Categories.add("Lunchroom");
        Categories.add("Maroccan");
        Categories.add("Mexican");
        Categories.add("Middle-eas");
        Categories.add("Pancake");
        Categories.add("Pizza");
        Categories.add("Portuguese");
        Categories.add("Regional");
        Categories.add("Russian");
        Categories.add("Sandwiches");
        Categories.add("Scandinavian");
        Categories.add("Snackbar");
        Categories.add("South-american");
        Categories.add("South-european");
        Categories.add("Steak-house");
        Categories.add("Surinamese");
        Categories.add("Sushi");
        Categories.add("Tapas");
        Categories.add("Thai");
        Categories.add("turkish");
        Categories.add("Vietnamese");
        Categories.add("Western-european");
        Categories.add("Wok");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, Categories);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner = (Spinner) findViewById(R.id.spinner);
        mySpinner.setAdapter(adapter);


        String txtFromSpinner = mySpinner.getSelectedItem().toString();

        url += "tags=" + txtFromSpinner +"&";

        return url;
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

    public void btnzoek(View view)
    {
        Intent result = new Intent(this, ResultActivity.class);
        startActivity(result);
    }


}
