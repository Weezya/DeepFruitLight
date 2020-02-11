package com.example.deepfruitlight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class LaunchActivity extends AppCompatActivity {

    private ImageView starter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        this.starter=findViewById(R.id.start);
        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Menu = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(Menu);
                finish();
            }
        });
    }
}
