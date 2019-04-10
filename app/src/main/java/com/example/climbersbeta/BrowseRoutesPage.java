package com.example.climbersbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class BrowseRoutesPage extends AppCompatActivity {

    RecyclerView rvRoutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_routes_page);

        rvRoutes = findViewById(R.id.rvRoutes);
    }
}
