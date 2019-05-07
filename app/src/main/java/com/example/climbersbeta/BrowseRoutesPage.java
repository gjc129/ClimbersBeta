package com.example.climbersbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.climbersbeta.Adapters.RoutesAdapter;
import com.example.climbersbeta.models.Route;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class BrowseRoutesPage extends AppCompatActivity {

    RecyclerView rvRoutes;
    List<Route> routes;


    //this link is relatively the area of the
    //changed maxResults value from 500 to 50 for testing
    static final String MP_API_URL_SPORT = "https://www.mountainproject.com/data/get-routes-for-lat-lon?lat=40.882&lon=-124.113&maxDistance=100&maxResults=50&minDiff=5.6&maxDiff=5.14d&key=200449770-856f491329dc082014b13d783de0e9c1";
    static final String MP_API_URL_BOULDER = "https://www.mountainproject.com/data/get-routes-for-lat-lon?lat=40.882&lon=-124.113&maxDistance=100&maxResults=500&minDiff=V0&maxDiff=V14&key=200449770-856f491329dc082014b13d783de0e9c1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_routes_page);

        rvRoutes = findViewById(R.id.rvRoutes);
        routes = new ArrayList<>();
        final RoutesAdapter adapter = new RoutesAdapter(this,routes);
        //rvRoutes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //rvRoutes.setAdapter(adapter);

        //client get function for the sport and traditional climbing routes in the Redwood Coast area
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(MP_API_URL_SPORT, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray routeJsonArray = response.getJSONArray("routes");
                    routes.addAll(Route.fromJsonArray(routeJsonArray));
                    adapter.notifyDataSetChanged();
                    //Log.d("smile", sportRoutes.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });

        //need to figure out why this request doesn't work

        //client get function for the boulder climbing routes in the Redwood Coast area
       client.get(MP_API_URL_BOULDER, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray routeJsonArray2 = response.getJSONArray("routes");
                    routes.addAll(Route.fromJsonArray(routeJsonArray2));
                    adapter.notifyDataSetChanged();
                    //Log.d("smile", boulderRoutes.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });

        rvRoutes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvRoutes.setAdapter(adapter);

    }
}
