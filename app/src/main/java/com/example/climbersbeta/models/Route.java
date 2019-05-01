package com.example.climbersbeta.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Route
{

    String name;
    String rating;
    String stars;
    String id;
    String location;
    String url;
    String image;


    public Route(JSONObject jsonObject) throws JSONException {

        //json object mapping to string variables for passing to browse route page.
        name = jsonObject.getString("name");
        rating = jsonObject.getString("rating");
        stars = jsonObject.getString("stars");
        id = jsonObject.getString("id");
        location = jsonObject.getString("location");
        url = jsonObject.getString("url");
        image = jsonObject.getString("imgSqSmall");


    }

    public static List<Route> fromJsonArray(JSONArray routeJsonArray) throws JSONException{
        List<Route> routes = new ArrayList<>();
        for(int i = 0; i < routeJsonArray.length(); i++)
        {
            routes.add(new Route(routeJsonArray.getJSONObject(i)));
        }
        return routes;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getStars() {
        return stars;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }
}
