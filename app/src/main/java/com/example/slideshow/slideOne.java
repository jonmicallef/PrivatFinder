package com.example.slideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class slideOne extends AppCompatActivity {
    private Button btnnext, btnskip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_one);


        btnnext = (Button) findViewById(R.id.btnnext);
        btnskip = (Button) findViewById(R.id.btnskip);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextSlide();
            }
        });
        btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skip();
            }
        });
    }

    public void openNextSlide() {
        Intent intent =new Intent(this, slideTwo.class);
        startActivity(intent);
    }
    public void skip() {
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    }


