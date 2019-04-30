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
    EditText etSubject;
    Button btnBack;
    Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compose_forum_post);

        // Find id for all views
        etForumPost = findViewById(R.id.etForumPost);
        etSubject = findViewById(R.id.etSubjectLine);
        btnBack = findViewById(R.id.btnBack);
        btnPost = findViewById(R.id.btnPost);

        btnPost.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent postForum = new Intent(ComposeForumPosts.this, MainForumPage.class);
                startActivity(postForum);
            }
        });
    }

}
