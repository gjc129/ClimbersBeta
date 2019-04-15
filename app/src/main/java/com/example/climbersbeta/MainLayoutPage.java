package com.example.climbersbeta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.climbersbeta.models.Route;
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
    //>>>>>>> d7cc8e2d492f69e95593d721d2ddfeb03ad0533d

    static final String MP_API_URL = "https://www.mountainproject.com/data/get-routes?routeIds=105748391,105750454,105749956&key=200449770-856f491329dc082014b13d783de0e9c1";

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

        // will send you to browse routes page
        btnBrowse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent sendToRouteViewIntent = new Intent(MainLayoutPage.this, BrowseRoutesPage.class);
                startActivity(sendToRouteViewIntent);
            }
        });

        // will send you to the map page
        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent sendToMapsActivityIntent = new Intent(MainLayoutPage.this, MapsActivityPage.class);
                startActivity(sendToMapsActivityIntent);
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

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(MP_API_URL, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray routeJsonArray = response.getJSONArray("routes");
                    routes = Route.fromJsonArray(routeJsonArray);
                    Log.d("smile", routes.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });

    }


}
