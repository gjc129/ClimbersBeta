package com.example.climbersbeta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainLayoutPage extends AppCompatActivity
{

    //declaration of views
    ImageView ivMap;
    Button btnBrowse;
    Button btnCreateAccount;
    Button btnForum;
    Button btnBulletinBoard;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout_page);

        //find ID for all values
        ivMap = findViewById(R.id.ivMap);
        btnBrowse = findViewById(R.id.btnBrowse);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        btnForum = findViewById(R.id.btnForum);
        btnBulletinBoard = findViewById(R.id.btnBulletinBoard);
//<<<<<<< HEAD
//=======

        // will send you to browse routes page
        btnBrowse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent sendToRouteViewIntent = new Intent(MainLayoutPage.this, RouteViewPage.class);
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
            public void onClick(View v)
            {
                Intent sendToMainForumIntent = new Intent(MainLayoutPage.this, MainForumPage.class);
                startActivity(sendToMainForumIntent);
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
//>>>>>>> d7cc8e2d492f69e95593d721d2ddfeb03ad0533d
    }


}
