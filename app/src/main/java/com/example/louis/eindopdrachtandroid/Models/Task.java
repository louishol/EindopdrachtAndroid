package com.example.louis.eindopdrachtandroid.Models;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Louis on 2-4-2015.
 */

public class Task extends AsyncTask<String, String, String> {
    public AsyncResponse delegate=null;

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }
    @Override
    public String doInBackground(String... urls) {
        try {

            String url = urls[0];
            HttpGet httppost = new HttpGet(url);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(httppost);
            // StatusLine stat = response.getStatusLine();
            int status = response.getStatusLine().getStatusCode();
            System.out.println("Status is " + status);
            if (status == 200) {
                HttpEntity entity = response.getEntity();
                String data = EntityUtils.toString(entity);
                return data;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}