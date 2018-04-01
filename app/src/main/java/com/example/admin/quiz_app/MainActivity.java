package com.example.admin.quiz_app;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;

    private Toast toast;

    private String Name;

    private String Email;

    private EditText name ;

    private EditText email ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getBooleanExtra("Exit",false)) {
            finish();
        }

        String file = "com.example.android.quizappSharepref";

        pref = getSharedPreferences(file,MODE_PRIVATE);

        name = findViewById(R.id.Name);

        email = findViewById(R.id.Email);

        Button next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login ();
            }
        });

        email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    login();
                }
                return false;
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor prefEditor = pref.edit();
        prefEditor.putString("Name" , Name);
        prefEditor.putString("Email" , Email);
        prefEditor.apply();
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    void showToast (String message) {

        if (toast != null) {
            toast.cancel();
        }

        toast = Toast.makeText(this, message , Toast.LENGTH_SHORT);
        toast.show();
    }

    void login () {
        Name = name.getEditableText().toString();
        Email = email.getEditableText().toString();

        if (Name.isEmpty() && Email.isEmpty()) {
            showToast ("Please fill above fields");
        } else if (Name.isEmpty()) {
            showToast ("Name can not be empty");
        } else if  (Email.isEmpty() ) {
            showToast ("Email address can not empty");
        }else if (!isEmailValid(Email)){
            showToast ("Please enter Valid Email");
        }else {
            Intent intent = new Intent(MainActivity.this , Instructions.class);
            startActivity(intent);
        }
    }

}
