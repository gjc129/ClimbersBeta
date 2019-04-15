package com.example.climbersbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainBulletinPage extends AppCompatActivity {


    Button btnComposePost;
    RecyclerView rvBulletinPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_bulletin_page);

        btnComposePost = findViewById(R.id.btnComposeBulletinPost);
        rvBulletinPosts = findViewById(R.id.rvBulletinPosts);

        btnComposePost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sendToBulletinPostPage = new Intent(MainBulletinPage.this, BulletinPostPage.class);
                startActivity(sendToBulletinPostPage);
            }
        });
    }
}

