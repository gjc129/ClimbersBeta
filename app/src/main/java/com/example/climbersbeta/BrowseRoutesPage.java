package com.example.climbersbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BrowseRoutesPage extends AppCompatActivity {

    RecyclerView rvRoutes;

    List<String> routes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_routes_page);

        rvRoutes = findViewById(R.id.rvRoutes);

        // initializing the list
        routes = new ArrayList<String>();

        RoutesAdapter routesAdapter = new RoutesAdapter(this, routes);

        // displays the information vertically
        rvRoutes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // hardcoded what to show on the forum post timeline because I was never
        // able to figure out how to add user input into a recycler view
        routes.add("Tin Man");
        routes.add("Some Climb In Arcata");
        routes.add("Another Climb In Arcata");
        routes.add("I don't know any climb names");
        routes.add("This one is a V0 and I don't know what that means");
        routes.add("Please Spare Me");
        routes.add("The Climbing Gym");
        routes.add("The Sock It To Me Climb");

        // in the parenthesis, put data i want to pass through
        routes.addAll(routes);
        routesAdapter.notifyDataSetChanged();
        rvRoutes.setAdapter(routesAdapter);
    }
}
