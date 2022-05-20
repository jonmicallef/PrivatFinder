package com.example.slideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class slideTwo extends AppCompatActivity {
    //defining buttons
    private Button btnnextt, btnskipp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_two);

        //finding the buttons in the xml file
    btnnextt = (Button) findViewById(R.id.btnnextt);
    btnskipp = (Button) findViewById(R.id.btnskipp);

    //giving the buttons functions
        btnnextt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openNextSlide();
        }
    });
        btnskipp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            skip();
        }
    });
}
    //both intents are going to the MainActivity as it is the last slide
    public void openNextSlide() {
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void skip() {
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}