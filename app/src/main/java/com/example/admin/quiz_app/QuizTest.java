package com.example.admin.quiz_app;

//TODO https://opentdb.com/api.php?amount=10 Apply api

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class QuizTest extends AppCompatActivity {

    private static final String Left_Time = "Left_time";

    private AlertDialog.Builder alertDialog ;

    private Intent intent;

    private int totalMarks = 0;

    private String at = "Attempted";

    private String Q3 = "Select Item";

    private String Q5 = "Select Item" ;

    private EditText Q2 , Q6 , Q9 ;

    private RadioGroup R1, R2 , R3, R4 ;

    private RadioButton Q11 , Q12 , Q13 , Q14 , Q41 , Q42 , Q43 , Q44 , Q71 , Q72 ,Q73 , Q74 , Q101 , Q102 , Q103 , Q104 ;

    private CheckBox Q81 , Q82 , Q83 , Q84;

    private Spinner spinner1 , spinner2;

    private CountDownTimer countDownTimer;

    private long start_time_mili = 60000;

    private long left_time_mili = start_time_mili;

    private boolean is_tick = false;

    private ImageView PlayPause,Done;

    private LinearLayout dc1 , dc2 , dc3 , dc4 ,dc5 ,dc6, dc7 , dc8, dc9,dc10;

    private TextView Timer , A1 , A2 , A3 , A4 , A5 , A6 , A7 , A8 , A9 , A10 , c1 , c2 , c3 , c4 , c5 , c6, c7 , c8 , c9, c10;

    private ScrollView Scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiztest);

        spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.spinnerQ3,android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Q3 = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.spinnerQ5,android.R.layout.simple_spinner_item);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Q5 = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Q11 = findViewById(R.id.oneradio1);

        Q12  = findViewById(R.id.oneradio2);

        Q13 = findViewById(R.id.oneradio3);

        Q14 = findViewById(R.id.oneradio4);

        Q2 = findViewById(R.id.edit1);

        Q41 = findViewById(R.id.tworadio1);

        Q42 = findViewById(R.id.tworadio2);

        Q43 = findViewById(R.id.tworadio3);

        Q44 = findViewById(R.id.tworadio4);

        Q6 = findViewById(R.id.edit2);

        Q71 = findViewById(R.id.threeradio1);

        Q72 = findViewById(R.id.threeradio2);

        Q73 = findViewById(R.id.threeradio3);

        Q74 = findViewById(R.id.threeradio4);

        Q81 = findViewById(R.id.checkbox1);

        Q82 = findViewById(R.id.checkbox2);

        Q83 = findViewById(R.id.checkbox3);

        Q84 = findViewById(R.id.checkbox4);

        Q9 = findViewById(R.id.edit3);

        Q101 = findViewById(R.id.fourradio1);

        Q102 = findViewById(R.id.fourradio2);

        Q103 = findViewById(R.id.fourradio3);

        Q104 = findViewById(R.id.fourradio4);

        Timer = findViewById(R.id.timer);

        Scroll = findViewById(R.id.scroll);

        A1 = findViewById(R.id.ans1);

        A2 = findViewById(R.id.ans2);

        A3 = findViewById(R.id.ans3);

        A4 = findViewById(R.id.ans4);

        A5 = findViewById(R.id.ans5);

        A6 = findViewById(R.id.ans6);

        A7 = findViewById(R.id.ans7);

        A8 = findViewById(R.id.ans8);

        A9 = findViewById(R.id.ans9);

        A10 = findViewById(R.id.ans10);

        c1 = findViewById(R.id.correct1);

        c2 = findViewById(R.id.correct2);

        c3 = findViewById(R.id.correct3);

        c4 = findViewById(R.id.correct4);

        c5 = findViewById(R.id.correct5);

        c6 = findViewById(R.id.correct6);

        c7 = findViewById(R.id.correct7);

        c8 = findViewById(R.id.correct8);

        c9 = findViewById(R.id.correct9);

        c10 = findViewById(R.id.correct10);

        dc1 = findViewById(R.id.C1);

        dc2 = findViewById(R.id.C2);

        dc3 = findViewById(R.id.C3);

        dc4 = findViewById(R.id.C4);

        dc5 = findViewById(R.id.C5);

        dc6 = findViewById(R.id.C6);

        dc7 = findViewById(R.id.C7);

        dc8 = findViewById(R.id.C8);

        dc9 = findViewById(R.id.C9);

        dc10 = findViewById(R.id.C10);

        R1 = findViewById(R.id.radio1);

        R2 = findViewById(R.id.radio2);

        R3 = findViewById(R.id.radio3);

        R4 = findViewById(R.id.radio4);

        alertDialog = new AlertDialog.Builder(this);

        Done = findViewById(R.id.done);
        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Done();
            }
        });

        PlayPause = findViewById(R.id.playpause);
        PlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!is_tick) {
                    Play(start_time_mili);
                } else {
                    Pause();
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putLong(Left_Time , left_time_mili);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        left_time_mili = savedInstanceState.getLong(Left_Time);
        Play(left_time_mili);
    }

    @Override
    public void onBackPressed() {
            countDownTimer.cancel();

            if (!(Timer.getText() == getString(R.string.done))) {

                alertDialog.setTitle("Do you want to submit");

                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Done();
                    }
                });

                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Play(left_time_mili);
                    }
                });

                alertDialog.create();
                alertDialog.show();
            } else {
                Exit();
            }
    }

    void Done () {

        notFreez(false);

        final String[] str = new String[1];

        attempted();

        Calculate();

        str[0] = "You had scored " + totalMarks;

        dialog (str[0]);

        PlayPause.setVisibility(View.INVISIBLE);

        Done.setVisibility(View.INVISIBLE);

        Timer.setText(R.string.done);

        Scroll.setVisibility(View.VISIBLE);

        notFreez(false);

        Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Timer.getText()== getString(R.string.done)) {

                    alertDialog.setTitle("Select Your Option");
                    alertDialog.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                 Exit();
                        }
                    });
                    alertDialog.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            intent = new Intent(QuizTest.this , QuizTest.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.create();
                    alertDialog.show();

                }else {
                    Restore();

                    str[0] = "Select Your option";

                    dialog(str[0]);
                }
            }
        });

        totalMarks = 0 ;
    }

    void notFreez(boolean val) {

        Q11.setClickable(val);
        Q12.setClickable(val);
        Q13.setClickable(val);
        Q14.setClickable(val);

        Q71.setClickable(val);
        Q72.setClickable(val);
        Q73.setClickable(val);
        Q74.setClickable(val);

        Q101.setClickable(val);
        Q102.setClickable(val);
        Q103.setClickable(val);
        Q104.setClickable(val);

        Q41.setClickable(val);
        Q42.setClickable(val);
        Q43.setClickable(val);
        Q44.setClickable(val);


        Q2.setFocusable(val);

        Q6.setFocusable(val);

        Q9.setFocusable(val);

        spinner1.setEnabled(val);

        spinner2.setEnabled(val);

        Q81.setClickable(val);
        Q82.setClickable(val);
        Q83.setClickable(val);
        Q84.setClickable(val);

    }

    void Play (long time) {

        Done.setVisibility(View.INVISIBLE);
        Scroll.setVisibility(View.VISIBLE);

        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                left_time_mili = millisUntilFinished;
                updatetime();
            }

            @Override
            public void onFinish() {
                is_tick = false;
                PlayPause.setImageResource(R.drawable.ic_play_arrow_black_36dp);
                PlayPause.setVisibility(View.INVISIBLE);
                Done.setVisibility(View.VISIBLE);
                Done();

            }
        }.start();

        PlayPause.setImageResource(R.drawable.ic_pause_black_36dp);
        is_tick = true;


    }

    void Pause () {
        Done.setVisibility(View.VISIBLE);
        Scroll.setVisibility(View.INVISIBLE);
        start_time_mili = left_time_mili;
        countDownTimer.cancel();
        is_tick = false;
        PlayPause.setImageResource(R.drawable.ic_play_arrow_black_36dp);
    }

//    void reset () {
//
//        Restore();
//
//        left_time_mili = 0;
//        start_time_mili = 60000;
//        Scroll.setVisibility(View.INVISIBLE);
//        updatetime();
//        is_tick = false;
//        if (countDownTimer != null) {
//            countDownTimer.cancel();
//        }
//        PlayPause.setImageResource(R.drawable.ic_play_arrow_black_36dp);
//
//        PlayPause.setVisibility(View.VISIBLE);
//        Done.setVisibility(View.VISIBLE);
//    }

    void updatetime () {
        int min = (int) (left_time_mili / 1000 ) /60;
        int sec = (int) (left_time_mili / 1000 ) % 60;

        Timer.setText(String.format(Locale.getDefault(),"%02d:%02d",min,sec));
    }

    void Calculate () {

        String c = "Correct Answer";
        if (A1.getText() == at) {
            if (Q13.isChecked()) {
                totalMarks += 1;
                A1.setText(c);
            } else {
                c1.setText(R.string.correct1);
                dc1.setVisibility(View.VISIBLE);
            }
        }

        if (A2.getText() == at) {
            if (Q2.getText().toString().equals(getString(R.string.correct2))) {
                totalMarks += 2;
                A2.setText(c);
            }else {
                dc2.setVisibility(View.VISIBLE);
                c2.setText(R.string.correct2);
            }
        }

        if (A3.getText() == at) {
            if (Q3.equals(getString(R.string.correct3))) {
                totalMarks += 1;
                A3.setText(c);
            }else {
                dc3.setVisibility(View.VISIBLE);
                c3.setText(R.string.correct3);
            }
        }

        if (A4.getText() == at) {
            if(Q42.isChecked()) {
                totalMarks += 1;
                A4.setText(c);
            }else {
                dc4.setVisibility(View.VISIBLE);
                c4.setText(R.string.correct4);
            }
        }
        if (A5.getText() == at) {
            if(Q5.equals(getString(R.string.correct5))) {
                totalMarks += 1;
                A5.setText(c);
            }else {
                dc5.setVisibility(View.VISIBLE);
                c5.setText(R.string.correct5);
            }
        }

        if (A6.getText() == at) {
            if(Q6.getText().toString().matches( getString(R.string.correctedit6))){
                totalMarks += 2;
                A6.setText(c);
            }else {
                dc6.setVisibility(View.VISIBLE);
                c6.setText(R.string.correctedit6);
            }
        }
        if (A7.getText() == at) {
            if (Q72.isChecked()) {
                totalMarks += 1;
                A7.setText(c);
            }else {
                dc7.setVisibility(View.VISIBLE);
                c7.setText(R.string.correct7);
            }
        }
        if (A8.getText() == at) {
            if(Q82.isChecked() && Q83.isChecked() && !Q81.isChecked() && !Q84.isChecked()) {
                totalMarks += 3;
                A8.setText(c);
            }else {
                dc8.setVisibility(View.VISIBLE);
                c8.setText(R.string.correct8);
            }
        }
        if (A9.getText() == at) {
            if(Q9.getText().toString().matches(getString(R.string.correctedit9))){
                totalMarks += 2;
                A9.setText(c);
            }else {
                dc9.setVisibility(View.VISIBLE);
                c9.setText(R.string.correctedit9);
            }
        }
        if (A10.getText() == at) {
            if(Q102.isChecked()) {
                totalMarks += 1;
                A10.setText(c);
            }else {
                dc10.setVisibility(View.VISIBLE);
                c10.setText(R.string.correct10);
            }
        }

        A1.setVisibility(View.VISIBLE);
        A2.setVisibility(View.VISIBLE);
        A3.setVisibility(View.VISIBLE);
        A4.setVisibility(View.VISIBLE);
        A5.setVisibility(View.VISIBLE);
        A6.setVisibility(View.VISIBLE);
        A7.setVisibility(View.VISIBLE);
        A8.setVisibility(View.VISIBLE);
        A9.setVisibility(View.VISIBLE);
        A10.setVisibility(View.VISIBLE);

    }

    void attempted() {

        String nat = "Not Attempted";
        A1.setText(nat);
        A2.setText(nat);
        A3.setText(nat);
        A4.setText(nat);
        A5.setText(nat);
        A6.setText(nat);
        A7.setText(nat);
        A8.setText(nat);
        A9.setText(nat);
        A10.setText(nat);

        if (Q11.isChecked() || Q12.isChecked() || Q13.isChecked() || Q14.isChecked()) {
            A1.setText(at);
        } else {
            c1.setText(R.string.correct1);
        }

        if (Q41.isChecked() || Q42.isChecked() || Q43.isChecked() || Q44.isChecked()) {
            A4.setText(at);
        } else {
            c4.setText(R.string.correct4);
        }

        if (Q71.isChecked() || Q72.isChecked() || Q73.isChecked() || Q74.isChecked()) {
            A7.setText(at);
        } else {
            c7.setText(R.string.correct7);
        }

        if (Q101.isChecked() || Q102.isChecked() || Q103.isChecked() || Q104.isChecked()) {
            A10.setText(at);
        } else {

            c10.setText(R.string.correct10);
        }

        if (!TextUtils.isEmpty(Q2.getText().toString().trim())) {
            A2.setText(at);
        } else {
            c2.setText(R.string.correct2);
        }

        if (!TextUtils.isEmpty(Q6.getText().toString().trim())) {
            A6.setText(at);
        } else {
            c6.setText(R.string.correctedit6);
        }

        if (!TextUtils.isEmpty(Q9.getText().toString().trim())) {
            A9.setText(at);
        } else {
            c9.setText(R.string.correctedit9);
        }

        if (Q81.isChecked() || Q82.isChecked() || Q83.isChecked() || Q84.isChecked()) {
            A8.setText(at);
        } else {
            c8.setText(R.string.correct8);
        }

        if (spinner1.getSelectedItemPosition() != 0) {
            A3.setText(at);
        } else {
            c3.setText(R.string.correct3);
        }

        if (spinner2.getSelectedItemPosition() != 0) {
            A5.setText(at);
        } else {
            c5.setText(R.string.correct5);
        }

    }

    void Restore () {

        dc1.setVisibility(View.GONE);
        dc2.setVisibility(View.GONE);
        dc3.setVisibility(View.GONE);
        dc4.setVisibility(View.GONE);
        dc5.setVisibility(View.GONE);
        dc6.setVisibility(View.GONE);
        dc7.setVisibility(View.GONE);
        dc8.setVisibility(View.GONE);
        dc9.setVisibility(View.GONE);
        dc10.setVisibility(View.GONE);

        A1.setVisibility(View.GONE);
        A2.setVisibility(View.GONE);
        A3.setVisibility(View.GONE);
        A4.setVisibility(View.GONE);
        A5.setVisibility(View.GONE);
        A6.setVisibility(View.GONE);
        A7.setVisibility(View.GONE);
        A8.setVisibility(View.GONE);
        A9.setVisibility(View.GONE);
        A10.setVisibility(View.GONE);

        R1.clearCheck();

        R2.clearCheck();

        R3.clearCheck();

        R4.clearCheck();

        Q2.setText("");

        Q6.setText("");

        Q9.setText("");

        spinner1.setSelection(0);

        spinner2.setSelection(0);

        Q81.setChecked(false);
        Q82.setChecked(false);
        Q83.setChecked(false);
        Q84.setChecked(false);

        notFreez(true);

    }

    void dialog (String string) {

        alertDialog.setTitle(string);

        alertDialog.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(QuizTest.this , QuizTest.class);
                startActivity(intent);
            }
        });

        alertDialog.setNegativeButton("Check Answer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                finish();
//                Toast.makeText(QuizTest.this , "Press Back Again to Exit",Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.create();
        alertDialog.show();
    }

    void Exit () {
        intent = new Intent(QuizTest.this , MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Exit", true);
        startActivity(intent);
    }
}

