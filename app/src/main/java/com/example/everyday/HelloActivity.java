package com.example.everyday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class HelloActivity extends AppCompatActivity {
    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        imageView = (ImageView) findViewById(R.id.imageView);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(View.GONE);
                Intent intent=new Intent(HelloActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3680);

    }
}