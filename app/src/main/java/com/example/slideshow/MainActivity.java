package com.example.slideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //defining variable names
    EditText username,password,repassword;
    Button btnSignUp,btnLogIn;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding them in the main_actvity_xml
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnLogIn = (Button) findViewById(R.id.btnLogIn);

        //to add to the DBHelper class
        myDB = new DBHelper(this);

        //when the button is pressed it will check the username,password and repassword fields
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                //all 3 fields are empty
                if(user.equals("") || pass.equals("") || repass.equals(""))
                {
                    //this will be displayed
                    Toast.makeText(MainActivity.this, "Fields are all empty", Toast.LENGTH_SHORT).show();
                }

                else{
                    //checks if password and repassword are the same
                    if(pass.equals(repass)) {
                        Boolean usercheckResult = myDB.checkusername(user);
                        //checks if username already exist in DBHelper
                        if(usercheckResult  == false){
                            Boolean regResult = myDB.insertData(user,pass);
                            //if above is good than account sign up is done
                            if(regResult == true){
                                //this will be displayed
                                Toast.makeText(MainActivity.this, "Sign Up successful", Toast.LENGTH_SHORT).show();
                                //be taken automatically to MainActivity
                                Intent intent = new Intent(getApplicationContext(),TeacherList.class);
                                startActivity(intent);
                            }
                            //if one of the sign up not successful display this
                            else{
                                Toast.makeText(MainActivity.this, "Sign Up failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        //if the username already exists this is displayed
                        else{
                            Toast.makeText(MainActivity.this, "Use Already exists", Toast.LENGTH_SHORT).show();                        }
                    }
                    //if the passwords dont match displays this
                    else{
                        Toast.makeText(MainActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //declaring the function to go to login
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}