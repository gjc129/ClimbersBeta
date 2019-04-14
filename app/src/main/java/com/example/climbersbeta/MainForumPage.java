package com.example.climbersbeta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
        setContentView(R.layout.main_forum_page);

        // Find view by id's
        btnComposePost = findViewById(R.id.btnComposeForumPost);
        rvPosts = findViewById(R.id.rvPosts);

        btnComposePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendToForumPostPage = new Intent(MainForumPage.this, ComposeForumPosts.class);
                startActivity(sendToForumPostPage);
            }
        });
    }
}
