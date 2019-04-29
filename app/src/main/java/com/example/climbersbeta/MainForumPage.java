package com.example.climbersbeta;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Locale;

public class MainForumPage extends AppCompatActivity
{
    // View declarations
    Button btnComposePost;
    RecyclerView rvPosts;

    private List<SimpleViewModel> generateList() {
        List<SimpleViewModel> simpleViewModelList = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            simpleViewModelList.add(new SimpleViewModel(String.format(Locale.US, "This is item %d", i)));
        }
        return simpleViewModelList;
    }
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

        //Bundle bundle = getIntent().getExtras();
        //String message = bundle.getString("message");

        rvPosts = findViewById(R.id.rvPosts);
    }

    // creating a class for our recycler view for forum posts
    public class Viewing
    {
        private String forumPost;

        // making setters and getters
        public Viewing(@NonNull final String forumPost)
        {
            setForumPosts(forumPost);
        }

        @NonNull
        public String getForumPosts()
        {
            return forumPost;
        }

        public void setForumPosts(@NonNull final String forumPosts)
        {
            this.forumPost = forumPosts;
        }
    }

}
