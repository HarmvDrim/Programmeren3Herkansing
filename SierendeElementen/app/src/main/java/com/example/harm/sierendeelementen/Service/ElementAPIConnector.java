package com.example.harm.sierendeelementen.Service;

import android.os.AsyncTask;
import android.util.Log;

import com.example.harm.sierendeelementen.Domain.Element;
import com.example.harm.sierendeelementen.Presentation.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static android.content.ContentValues.TAG;

/**
 * Created by harm on 23-6-2018.
 */

public class ElementAPIConnector extends AsyncTask<String,Void,String>{
    private MainActivity listener;

    public ElementAPIConnector(MainActivity listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        Log.e("Test", "doInBackground ApiController aangeroepen");
        BufferedReader bufferedReader = null;
        String response = "";

        try{
            URL url = new URL(strings[0]);
            URLConnection connection = url.openConnection();

            bufferedReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            response = bufferedReader.readLine().toString();
            String line;
            while ((line = bufferedReader.readLine()) != null){
                response += line;
            }


        } catch (Exception e) {
            return null;
        } finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        Log.e("Test", "Data is verzameld uit de API");
        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        Log.e("Test", "onPostExecute ApiController aangeroepen");
        Log.i(TAG, "onPostExecute " + response);

        if (response == null || response == ""){
            Log.e(TAG, "onPostExecute response was leeg");
            return;
        }

        Log.e("Test123", "Bereikt");
        try {
            JSONObject elementOBJECT = new JSONObject(response);
            JSONArray elementArray = new JSONArray(elementOBJECT.getString("features"));
            Log.e("Test", "JSON object is gefiltert tot en met features");
            for (int idx = 0; idx < elementArray.length(); idx++){
                JSONObject features = elementArray.getJSONObject(idx);
                JSONObject element = features.getJSONObject("attributes");

                String idNummer = element.getString("IDENTIFICATIE");

                String naamObject = element.getString("AANDUIDINGOBJECT");

                String geoLigging = element.getString("GEOGRAFISCHELIGGING");

                String kunstenaar = element.getString("KUNSTENAAR");

                String materiaal = element.getString("MATERIAAL");

                String omschrijving = element.getString("OMSCHRIJVING");

                String ondergrond = element.getString("ONDERGROND");

                String imageURL = element.getString("URL");

                Element elements = new Element(
                        idNummer,
                        naamObject,
                        geoLigging,
                        imageURL,
                        kunstenaar,
                        omschrijving,
                        materiaal,
                        ondergrond
                );

                listener.addElement(elements);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
