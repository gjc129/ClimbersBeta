package com.example.climbersbeta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

public class MainForumPage extends AppCompatActivity
{

    // View declarations
    Button btnComposePost;
    RecyclerView rvPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_main_page);

        // Find view by id's
        btnComposePost = findViewById(R.id.btnComposePost);
        rvPosts = findViewById(R.id.rvPosts);
    }
}
