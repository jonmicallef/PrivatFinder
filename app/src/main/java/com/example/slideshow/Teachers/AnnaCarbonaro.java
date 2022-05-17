package com.example.slideshow.Teachers;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.slideshow.R;


public class AnnaCarbonaro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewteacher);

        //Teacher Details
        String Tname = "Ms Anna Carbonaro";
        String Tsubject = "Maltese - Bahar ic-Caghaq";
        String Tdescr = "Writer, teacher and auditor. Offering help for O,I-level for Maltese in small groups";
        String TPrice = " € 17/hr";

        //putting name into viewteacher.xml
        TextView name = (TextView) findViewById(R.id.TeacherName);
        name.setText(Tname);

        TextView subject = (TextView) findViewById(R.id.TeacherSubject);
        subject.setText(Tsubject);

        TextView price = (TextView) findViewById(R.id.Price);
        price.setText(TPrice);

        TextView desc = (TextView) findViewById(R.id.TeacherDescription);
        desc.setText(Tdescr);

        //contacting teacher by phone
        Button buttonCall;
        buttonCall = findViewById(R.id.btnCall);
        buttonCall.setOnClickListener(new View.OnClickListener() { //method if user clicks on contact by phone
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL); //opening call app
                intent.setData(Uri.parse("tel:+35699230065"));  //passing phone number to call app
                startActivity(intent);
            }

        });
        //contacting teacher by email
        Button buttonEmail;
        buttonEmail = findViewById(R.id.buttonEmail);

        buttonEmail.setOnClickListener(new View.OnClickListener() { //method if user clicks on contact by email
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND); //opening email app
                intent.setType("plain/text");
                //passing teacher email details and pre setting subject for user
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "annacarb@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Tutorials inquiry");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(intent, ""));
            }
        });


    }
}

