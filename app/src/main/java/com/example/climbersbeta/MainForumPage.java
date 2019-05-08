package com.example.climbersbeta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainForumPage extends ComposeForumPosts {
    // View declarations
    Button btnComposePost;
    RecyclerView rvPosts;
    EditText etForumPost;

    // from item_forum.xml

    List<String> forumPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_forum_page);

        // Find view by id's
        btnComposePost = findViewById(R.id.btnComposeForumPost);
        rvPosts = findViewById(R.id.rvPosts);
        etForumPost = findViewById(R.id.etForumPost);

        // initializing the list
        forumPosts = new ArrayList<String>();

        ForumAdapter forumAdapters = new ForumAdapter(this, forumPosts);

        // displays the information vertically
        rvPosts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // hardcoded what to show on the forum post timeline because I was never
        // able to figure out how to add user input into a recycler view
        forumPosts.add("That climb I did the other day was killer. I can't feel my forearms!");
        forumPosts.add("I am hungry for more climbing after the last day. Who wants to join?");
        forumPosts.add("I'm doing very good now, sock it to me!");
        forumPosts.add("Good job Climbers Beta, you're doing good!");
        forumPosts.add("I didn't know  the meaning of life until I started using this app, wow!");
        forumPosts.add("Marco is so cool and handsome.");

        // in the parenthesis, put data i want to pass through
        forumPosts.addAll(forumPosts);
        forumAdapters.notifyDataSetChanged();
        rvPosts.setAdapter(forumAdapters);

        // setting the text on the recycler view


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
