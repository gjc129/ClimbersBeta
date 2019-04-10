package com.example.climbersbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainBulletinPage extends AppCompatActivity {

    // declaration of views
    Button btnComposePost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_bulletin_page);

        btnComposePost = findViewById(R.id.btnComposePost);


        // the compose button will send you to the Bulletin Post Page
        btnComposePost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sendToBullPost = new Intent(MainBulletinPage.this, BulletinPostPage.class);
                startActivity(sendToBullPost);
            }
        });
    }
}

