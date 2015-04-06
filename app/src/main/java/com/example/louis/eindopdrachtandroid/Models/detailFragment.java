package com.example.louis.eindopdrachtandroid.Models;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.louis.eindopdrachtandroid.R;

import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class detailFragment extends Fragment implements AsyncResponse {

    Task task;
    TextView txtName;
    TextView txtDescrip;
    TextView txtCountry;
    TextView txtPhone;
    TextView txtStreet;
    TextView txtCity;


    public detailFragment() {
        // Required empty public constructor
        task = new Task();
        task.delegate = this;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View RootView = inflater.inflate(R.layout.fragment_detail, container, false);

        txtName = (TextView) RootView.findViewById(R.id.txtNaam);
        txtDescrip = (TextView) RootView.findViewById(R.id.txtBeschrijving);
        txtCountry = (TextView) RootView.findViewById(R.id.txtLand);
        txtPhone = (TextView) RootView.findViewById(R.id.txtTelefoon);
        txtStreet = (TextView) RootView.findViewById(R.id.txtAdress);
        txtCity = (TextView) RootView.findViewById(R.id.txtWoonplaats);

        Bundle b = getActivity().getIntent().getExtras();

        String id = b.getString("id");
        if(id != null)
        {
            updateContent(Integer.parseInt(id));
        }
        return RootView;
    }


    public void updateContent(int id)
    {
        task.execute("https://api.eet.nu/venues/"+id);
    }
    public void processFinish(String output)
    {
        try {
            Log.d("Myapp",output);
            JSONObject obj = new JSONObject(output);
            String name = obj.getString("name");
            String description = obj.getString("description");
            String phone = obj.getString("telephone");

            JSONObject adress = obj.getJSONObject("address");

            String city = adress.getString("city");
            String country = adress.getString("country");
            String street = adress.getString("street");

            txtCity.setText(city);
            txtPhone.setText(phone);
            txtDescrip.setText(description);
            txtCountry.setText(country);
            txtName.setText(name);
            txtStreet.setText(street);
        }
        catch (Throwable t)
        {
            t.printStackTrace();
            Log.d("Myapp", t.toString());
        }
    }
}
