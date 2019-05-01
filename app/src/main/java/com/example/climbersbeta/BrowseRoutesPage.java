package com.example.climbersbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.climbersbeta.models.Route;

import java.util.ArrayList;
import java.util.List;

public class BrowseRoutesPage extends AppCompatActivity {

    RecyclerView rvRoutes;
    List<String> Routes = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_routes_page);

        rvRoutes = findViewById(R.id.rvRoutes);

        Routes.add("High Desert");
        Routes.add("Redwood Coast");

    }
}
