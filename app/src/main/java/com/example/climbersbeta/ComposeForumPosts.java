package com.example.climbersbeta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComposeForumPosts extends AppCompatActivity {

    // View declarations
    EditText etForumPost;
    Button btnBack;
    Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compose_forum_post);

        // Find id for all views
        etForumPost = findViewById(R.id.etForumPost);
        btnBack = findViewById(R.id.btnBack);
        btnPost = findViewById(R.id.btnPost);

        // button is supposed to send the forum post to the recycler view on MainForumPage
        btnPost.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String post = etForumPost.getText().toString();
                Intent postForum = new Intent(ComposeForumPosts.this, MainForumPage.class);
                postForum.putExtra("POST", post);
                startActivity(postForum);
            }
        });

        // if click post, i have to press back several times before i can go to home page
        // just made the back button take me home
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sendHome = new Intent(ComposeForumPosts.this, MainLayoutPage.class);
                startActivity(sendHome);
            }
        });
    }

    public EditText getEtForumPost(){
        return etForumPost;
    }
    public void setEtForumPost(EditText forumPost) {
        etForumPost = forumPost;
    }
}
