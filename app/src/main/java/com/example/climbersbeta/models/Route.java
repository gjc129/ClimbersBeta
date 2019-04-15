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

    public Route(JSONObject jsonObject) throws JSONException {
        name = jsonObject.getString("name");
        rating = jsonObject.getString("rating");
        stars = jsonObject.getString("stars");
        id = jsonObject.getString("id");
        location = jsonObject.getString("location");

    }

    public static List<Route> fromJsonArray(JSONArray routeJsonArray) throws JSONException{
        List<Route> routes = new ArrayList<>();
        for(int i = 0; i < routeJsonArray.length(); i++)
        {
            routes.add(new Route(routeJsonArray.getJSONObject(i)));
        }
        return routes;
    }
}
