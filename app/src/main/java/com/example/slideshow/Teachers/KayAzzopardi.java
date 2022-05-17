package com.example.slideshow.Teachers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.slideshow.R;

//refer to AnnaCarbonaro.class for inline comments due to repeated method
public class KayAzzopardi extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewteacher);

        String Tname = "Dr Kay Azzopardi";
        String Tsubject = "Biology - Online";
        String Tdescr = "Lecturer at the university of Malta. Offering help for A-level ONLY in small groups. ";
        String TPrice = " € 23/hr";

        TextView name = (TextView) findViewById(R.id.TeacherName);
        name.setText(Tname);

        TextView subject = (TextView) findViewById(R.id.TeacherSubject);
        subject.setText(Tsubject);

        TextView price = (TextView) findViewById(R.id.Price);
        price.setText(TPrice);

        TextView desc = (TextView) findViewById(R.id.TeacherDescription);
        desc.setText(Tdescr);

        Button buttonCall;
        buttonCall = findViewById(R.id.btnCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+35699230045"));
                startActivity(intent);
            }

        });

        Button buttonEmail;
        buttonEmail = findViewById(R.id.buttonEmail);

        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "drkayazz@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Tutorials inquiry");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(intent, ""));
            }
        });


    }
}

