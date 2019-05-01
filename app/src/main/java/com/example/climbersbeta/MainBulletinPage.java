package com.example.climbersbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainBulletinPage extends AppCompatActivity {


    Button btnComposePost;
    RecyclerView rvBulletinPosts;

    List<BulletinPostPage> bulletinPostPageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_bulletin_page);

        btnComposePost = findViewById(R.id.btnComposeBulletinPost);
        rvBulletinPosts = findViewById(R.id.rvBulletinPosts);

        // initializing the list
        bulletinPostPageList = new ArrayList<>();

        BulletinAdapter bulletinAdapter = new BulletinAdapter(this, bulletinPostPageList);

        // displays the information vertically
        rvBulletinPosts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvBulletinPosts.setAdapter(bulletinAdapter);

        btnComposePost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sendToBulletinPostPage = new Intent(MainBulletinPage.this, BulletinPostPage.class);
                startActivity(sendToBulletinPostPage);
            }
        });
    }
}

