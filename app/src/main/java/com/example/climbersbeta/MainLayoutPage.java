package com.example.climbersbeta;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;

import com.example.climbersbeta.models.Route;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainLayoutPage extends AppCompatActivity
{

    //declaration of views
    ImageView ivMap;
    Button btnBrowse;
    Button btnProfile;
    Button btnForum;
    Button btnBulletinBoard;
    List<Route> routes;
    List<Route> sportRoutes;
    List<Route> boulderRoutes;
    TextView tvLogo;
    //>>>>>>> d7cc8e2d492f69e95593d721d2ddfeb03ad0533d

    //this link is relatively the area of the
    static final String MP_API_URL_SPORT = "https://www.mountainproject.com/data/get-routes-for-lat-lon?lat=40.882&lon=-124.113&maxDistance=100&maxResults=500&minDiff=5.6&maxDiff=5.14d&key=200449770-856f491329dc082014b13d783de0e9c1";
    static final String MP_API_URL_BOULDER = "https://www.mountainproject.com/data/get-routes-for-lat-lon?lat=40.882&lon=-124.113&maxDistance=100&maxResults=500&minDiff=V0&maxDiff=V14&key=200449770-856f491329dc082014b13d783de0e9c1";

    // setting up if google maps is up to date
    private static final String TAG = "MainLayoutPage";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout_page);

        //find ID for all values
        ivMap = findViewById(R.id.ivMap);
        btnBrowse = findViewById(R.id.btnBrowse);
        btnProfile = findViewById(R.id.btnProfile);
        btnForum = findViewById(R.id.btnForum);
        btnBulletinBoard = findViewById(R.id.btnBulletinBoard);
        ivMap.setImageResource(R.drawable.yosemite);
        tvLogo =findViewById(R.id.tvLogo);




        // checks to see if you are up to date on google store first
        // if you are then the button will work
        if(isServicesOK())
        {
            ivMap.setImageResource(R.drawable.yosemite);
            // will send you to the map page
            ivMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent sendToMapsActivityIntent = new Intent(MainLayoutPage.this, MapsActivityPage.class);
                    startActivity(sendToMapsActivityIntent);
                }
            });
        }

        // will send you to browse routes page
        btnBrowse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent sendToRouteViewIntent = new Intent(MainLayoutPage.this, BrowseRoutesPage.class);
                startActivity(sendToRouteViewIntent);
            }
        });

        // will send you to the forum page
        btnForum.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent sendToForumIntent = new Intent(MainLayoutPage.this, MainForumPage.class);
                startActivity(sendToForumIntent);
            }
        });


        // will send you to the bulletin page
        btnBulletinBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent sendToMainBulletinIntent = new Intent(MainLayoutPage.this, MainBulletinPage.class);
                startActivity(sendToMainBulletinIntent);
            }
        });

    /*  btnProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sendToProfilePage = new Intent(MainLayoutPage.this,class);
                startActivity(sendToProfilePage);
            }
        }); */

        //client get function for the sport and traditional climbing routes in the Redwood Coast area
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(MP_API_URL_SPORT, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray routeJsonArray = response.getJSONArray("routes");
                    sportRoutes = Route.fromJsonArray(routeJsonArray);
                    Log.d("smile", sportRoutes.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });


/*
        //client get function for the boulder climbing routes in the Redwood Coast area
       client.get(MP_API_URL_BOULDER, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray routeJsonArray = response.getJSONArray("routes");
                    boulderRoutes = Route.fromJsonArray(routeJsonArray);
                    Log.d("smile", boulderRoutes.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
*/


    }

    // checks to see if you are up to date
    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainLayoutPage.this);

        if(available == ConnectionResult.SUCCESS)
        {
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available))
        {
            // an error occurred but we can resolve it
            Log.d(TAG, "isServicesOK: an error occurred");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainLayoutPage.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else
        {
            Toast.makeText(this, "You can't make a map request", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
