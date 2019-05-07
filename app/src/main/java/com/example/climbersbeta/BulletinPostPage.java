package com.example.climbersbeta;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BulletinPostPage extends AppCompatActivity {

    TextView etSubjectLine;
    TextView etBody;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulletin_post_page);

        etSubjectLine = findViewById(R.id.etSubjectLine);
        etBody = findViewById(R.id.etBody);


    }

    // setter and getter for the bulletin body
    public TextView getEtBody(){
        return etBody;
    }
    public void setEtBody(TextView body) {
        etBody = body;
    }
}
