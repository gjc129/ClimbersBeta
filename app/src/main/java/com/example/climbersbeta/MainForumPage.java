package com.example.climbersbeta;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainForumPage extends AppCompatActivity {
    // View declarations
    Button btnComposePost;
    RecyclerView rvPosts;

    // from item_forum.xml
    TextView tvForum;

    List<ComposeForumPosts> composeForumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_forum_page);

        // Find view by id's
        btnComposePost = findViewById(R.id.btnComposeForumPost);
        rvPosts = findViewById(R.id.rvPosts);

        tvForum = findViewById(R.id.tvForum);

        // initializing the list
        composeForumList = new ArrayList<>();

        forumAdapter forumAdapters = new forumAdapter(this, composeForumList);

        // displays the information vertically
        rvPosts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvPosts.setAdapter(forumAdapters);

        tvForum.setText(getIntent().getStringExtra("POST"));

        // compose post button sends user to create post screen.
        btnComposePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendToForumPostPage = new Intent(MainForumPage.this, ComposeForumPosts.class);
                startActivity(sendToForumPostPage);
            }
        });
    }
}
