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

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;

    private String stringName;

    private String stringEmail;

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

        email.setOnEditorActionListener(new EditText.OnEditorActionListener() {
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
        prefEditor.putString("Name", stringName);
        prefEditor.putString("Email", stringEmail);
        prefEditor.apply();
    }

    void login () {
        stringName = name.getEditableText().toString().toLowerCase();
        stringEmail = email.getEditableText().toString().toLowerCase();

        if (stringName.isEmpty() && stringEmail.isEmpty()) {
            email.setError("Email can not be empty");
            name.setError("Name can not be empty");
        } else if (stringName.isEmpty()) {
            name.setError("Name can not be empty");
        } else if (stringEmail.isEmpty()) {
            email.setError("Email can not be empty");
        } else if (isInvalidEmail(stringEmail)) {
            email.setError("Invalid Email");
        }else {
            Intent intent = new Intent(MainActivity.this , Instructions.class);
            startActivity(intent);
        }
    }

    boolean isInvalidEmail(String email) {
        boolean returnVal = true;
        int atTheRateIndex = email.lastIndexOf("@");

        if (email.contains("@")) {
            if (atTheRateIndex > 0) {
                if (email.lastIndexOf(".") > atTheRateIndex + 1) {
                    if (!email.endsWith(",")) {
                        returnVal = false;
                    }
                }
            }
        }
        return returnVal;
    }
}