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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainForumPage extends AppCompatActivity
{
    // View declarations
    Button btnComposePost;
    RecyclerView rvPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        SimpleAdapter adapter = new SimpleAdapter(generateSimpleList());
        rvPosts.setLayoutManager(new LinearLayoutManager(this));
        rvPosts.setHasFixedSize(true);

        rvPosts.setAdapter(adapter);
    }

    private List<SimpleViewModel> generateSimpleList(){
         List<SimpleViewModel> simpleViewModelList = new ArrayList<>();

         for(int i = 0; i < 100; i++) {
            simpleViewModelList.add(new SimpleViewModel(String.format(Locale.US, "This is item %d", i)));
         }
            return simpleViewModelList;
    }
}

    // creating a class for our recycler view for forum posts
    private class SimpleViewModel{
        private String simplePost;

        public SimpleViewModel(@NonNull final String simplePost){
            setSimplePost(simplePost);
        }

        @NonNull
        public String getSimplePost(){
            return simplePost;
        }

        public void setSimplePost(@NonNull final String simplePost){
            this.simplePost = simplePost;
        }
    }
