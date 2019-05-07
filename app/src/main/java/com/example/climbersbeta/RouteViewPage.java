package com.example.climbersbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.climbersbeta.models.Route;

import org.parceler.Parcels;

public class RouteViewPage extends AppCompatActivity
{
    //View declarations
    TextView tvRouteTitle;
    TextView tvRating;
    TextView tvDescription;
    TextView tvDescriptionBody;
    //TextView tvLocation;
    //TextView tvLocationBody;
    //TextView tvProtection;
    //TextView tvProtectionBody;
    TextView tvType;
    TextView tvTypeBody;
    ImageView ivRouteImage;
    RatingBar rbRating;
    Route route;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_view);

        route = Parcels.unwrap(getIntent().getParcelableExtra(Route.class.getName()));


        //find id for all views
        tvRouteTitle = findViewById(R.id.tvRouteTitle);
        tvRating = findViewById(R.id.tvRating);
        tvDescription = findViewById(R.id.tvDescription);
        tvDescriptionBody = findViewById(R.id.tvDescriptionBody);
        //tvLocation = findViewById(R.id.tvLocation);
        //tvLocationBody = findViewById(R.id.tvLocationBody);
        //tvProtection = findViewById(R.id.tvProtection);
        //tvProtectionBody = findViewById(R.id.tvProtectionBody);
        tvType = findViewById(R.id.tvType);
        tvTypeBody = findViewById(R.id.tvTypeBody);
        ivRouteImage = findViewById(R.id.ivRouteImage);
        rbRating = findViewById(R.id.rbRating);

        ivRouteImage.setImageResource(R.drawable.tinman);
        rbRating.setRating((float) 2.3);

    }
}
