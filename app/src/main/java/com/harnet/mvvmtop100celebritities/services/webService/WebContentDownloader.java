package com.harnet.mvvmtop100celebritities.services.webService;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebContentDownloader extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {
        Log.i("MVVMCeleb:", "Trying to get a data of celebrities");
        StringBuilder site = new StringBuilder();
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();

            while (data != -1) {
                char current = (char) data;
                site.append(current);
                data = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return site.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("MVVMCeleb:", "List of celebrities was gotten");
    }
}
