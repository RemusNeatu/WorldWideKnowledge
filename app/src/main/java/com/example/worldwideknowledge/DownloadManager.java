package com.example.worldwideknowledge;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadManager {
    private static final String url = "https://restcountries.eu/rest/v2/all";

    public static void downloadCountriesInfo(Context context) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DownloadManager: ", "successfully download: " + url);
                        parse_countries(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DownloadManager", "That didn't work! - " + error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private static void parse_countries(String all_countries) {
        JSONArray cs = null;

        try {
            cs = new JSONArray(all_countries);

            for (int i = 0; i < cs.length(); ++i) {
                JSONObject c = (JSONObject) cs.get(i);

                if (c.getString("capital").equals("")) {
                    continue;
                }

                if (c.getString("region").equals("Americas")) {
                    if (c.getString("subregion").equals("Northern America") ||
                            c.getString("subregion").equals("Central America") ||
                            c.getString("subregion").equals("Caribbean")) {
                        Globe.addCountry(new Country(c.getString("name"), c.getString("capital"),
                                "North America", c.getString("subregion")), "North America");
                    } else {
                        Globe.addCountry(new Country(c.getString("name"), c.getString("capital"),
                                "South America", c.getString("subregion")), "South America");
                    }

                    continue;
                }

                Globe.addCountry(new Country(c.getString("name"), c.getString("capital"),
                        c.getString("region"), c.getString("subregion")), c.getString("region"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
