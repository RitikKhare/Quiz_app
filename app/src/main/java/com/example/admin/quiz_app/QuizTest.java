package com.example.admin.quiz_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.Locale;

public class QuizTest extends AppCompatActivity {

    private static final String LEFT_TIME = "Left_time";

    private static final String TIMER_STATE = "Timer_State";

    private static final String CURRENT_QUESTION = "Current_Question";

    private Toast toast;

    private AlertDialog.Builder alertDialog;

    private Intent intent;

    private int totalMarks = 0;

    private String attempted = "Attempted";

    private String q3 = "Select Item";

    private String q5 = "Select Item";

    private EditText q2;
    private EditText q6;
    private EditText q9;

    private RadioGroup r1;
    private RadioGroup r2;
    private RadioGroup r3;
    private RadioGroup r4;

    private RadioButton q11;
    private RadioButton q12;
    private RadioButton q13;
    private RadioButton q14;
    private RadioButton q41;
    private RadioButton q42;
    private RadioButton q43;
    private RadioButton q44;
    private RadioButton q71;
    private RadioButton q72;
    private RadioButton q73;
    private RadioButton q74;
    private RadioButton q101;
    private RadioButton q102;
    private RadioButton q103;
    private RadioButton q104;

    private CheckBox q81;
    private CheckBox q82;
    private CheckBox q83;
    private CheckBox q84;

    private Spinner spinner1;
    private Spinner spinner2;

    private CountDownTimer countDownTimer;

    private long startTimeMiliS = 60000;

    private long leftTimeMiliS = startTimeMiliS;

    private boolean isTick = false;

    private ImageView playPause;
    private ImageView done;

    private LinearLayout dc1;
    private LinearLayout dc2;
    private LinearLayout dc3;
    private LinearLayout dc4;
    private LinearLayout dc5;
    private LinearLayout dc6;
    private LinearLayout dc7;
    private LinearLayout dc8;
    private LinearLayout dc9;
    private LinearLayout dc10;

    private TextView timer;
    private TextView a1;
    private TextView a2;
    private TextView a3;
    private TextView a4;
    private TextView a5;
    private TextView a6;
    private TextView a7;
    private TextView a8;
    private TextView a9;
    private TextView a10;
    private TextView c1;
    private TextView c2;
    private TextView c3;
    private TextView c4;
    private TextView c5;
    private TextView c6;
    private TextView c7;
    private TextView c8;
    private TextView c9;
    private TextView c10;

    private ViewFlipper flipper;

    private RelativeLayout questionNavigator;

    private ImageButton nextButton;
    private ImageButton previousButton;

    private LinearLayout headerLinearLayout;

    private ViewGroup.LayoutParams layoutParamsFullHeight;
    private ViewGroup.LayoutParams layoutParamsWrapHeight;

    private int quesNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_test);

        initializeVariables();

        q9.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loadNextQuestion();
                }

                return true;
            }
        });

        quesNumber = 0;

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNextQuestion();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPreviousQuestion();
            }
        });

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.spinnerQ3, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                q3 = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spinnerQ5, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                q5 = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        alertDialog = new AlertDialog.Builder(this);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Done();
            }
        });

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTick) {
                    play(startTimeMiliS);
                } else {
                    pause();
                }
            }
        });
    }

    //    Initialize All the Variable Declared
    void initializeVariables() {

        layoutParamsFullHeight = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        layoutParamsWrapHeight = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        q11 = findViewById(R.id.oneradio1);

        q12 = findViewById(R.id.oneradio2);

        q13 = findViewById(R.id.oneradio3);

        q14 = findViewById(R.id.oneradio4);

        q2 = findViewById(R.id.edit1);

        q41 = findViewById(R.id.tworadio1);

        q42 = findViewById(R.id.tworadio2);

        q43 = findViewById(R.id.tworadio3);

        q44 = findViewById(R.id.tworadio4);

        q6 = findViewById(R.id.edit2);

        q71 = findViewById(R.id.threeradio1);

        q72 = findViewById(R.id.threeradio2);

        q73 = findViewById(R.id.threeradio3);

        q74 = findViewById(R.id.threeradio4);

        q81 = findViewById(R.id.checkbox1);

        q82 = findViewById(R.id.checkbox2);

        q83 = findViewById(R.id.checkbox3);

        q84 = findViewById(R.id.checkbox4);

        q9 = findViewById(R.id.edit3);

        q101 = findViewById(R.id.fourradio1);

        q102 = findViewById(R.id.fourradio2);

        q103 = findViewById(R.id.fourradio3);

        q104 = findViewById(R.id.fourradio4);

        timer = findViewById(R.id.timer);

        flipper = findViewById(R.id.viewflipper);

        a1 = findViewById(R.id.ans1);

        a2 = findViewById(R.id.ans2);

        a3 = findViewById(R.id.ans3);

        a4 = findViewById(R.id.ans4);

        a5 = findViewById(R.id.ans5);

        a6 = findViewById(R.id.ans6);

        a7 = findViewById(R.id.ans7);

        a8 = findViewById(R.id.ans8);

        a9 = findViewById(R.id.ans9);

        a10 = findViewById(R.id.ans10);

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

        r1 = findViewById(R.id.radio1);

        r2 = findViewById(R.id.radio2);

        r3 = findViewById(R.id.radio3);

        r4 = findViewById(R.id.radio4);

        questionNavigator = findViewById(R.id.bottom_navigation_panel);

        flipper = findViewById(R.id.viewflipper);

        nextButton = findViewById(R.id.next_view);

        previousButton = findViewById(R.id.previous_view);

        spinner1 = findViewById(R.id.spinner1);

        spinner2 = findViewById(R.id.spinner2);

        done = findViewById(R.id.done);

        playPause = findViewById(R.id.playpause);

        headerLinearLayout = findViewById(R.id.headerLinerLayout);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        countDownTimer.cancel();

        outState.putLong(LEFT_TIME, leftTimeMiliS);
        outState.putBoolean(TIMER_STATE, isTick);
        outState.putInt(CURRENT_QUESTION, quesNumber);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        leftTimeMiliS = savedInstanceState.getLong(LEFT_TIME);
        isTick = savedInstanceState.getBoolean(TIMER_STATE);
        quesNumber = savedInstanceState.getInt(CURRENT_QUESTION);

        flipper.setDisplayedChild(quesNumber);

        if (isTick) {
            play(leftTimeMiliS);
        } else {
            updateTime();
            startTimeMiliS = leftTimeMiliS;
            setQuestionVisibility(View.GONE);
        }
    }


    @Override
    public void onBackPressed() {
        countDownTimer.cancel();

        if (!(timer.getText() == getString(R.string.done))) {

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
                    play(leftTimeMiliS);
                }
            });

            alertDialog.create();
            alertDialog.show();
        } else {
            finish();
        }
    }

    //    TO calculate score and Other UI changes
    void Done() {

        leftTimeMiliS = 0;

        notFreez(false);

        final String[] str = new String[1];

        attempted();

        calculate();

        dialogDone("You had scored " + totalMarks);

        playPause.setVisibility(View.INVISIBLE);

        done.setVisibility(View.INVISIBLE);

        timer.setText(R.string.done);


        setQuestionVisibility(View.VISIBLE);

        notFreez(false);

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timer.getText() == getString(R.string.done)) {

                    alertDialog.setTitle("Select Your Option");
                    alertDialog.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            exit();
                        }
                    });
                    alertDialog.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            intent = new Intent(QuizTest.this, QuizTest.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.create();
                    alertDialog.show();

                }
//                  else {
//                    restore();
//
//                    dialogDone("Select Your option");
//                }
            }
        });

        totalMarks = 0;
    }

    //    To Freez or unFreez : the Radio Button , Spinner , EditText , CheckBox
//    @param Boolean : To Freez or unFreez
    void notFreez(boolean val) {

        q11.setClickable(val);
        q12.setClickable(val);
        q13.setClickable(val);
        q14.setClickable(val);

        q71.setClickable(val);
        q72.setClickable(val);
        q73.setClickable(val);
        q74.setClickable(val);

        q101.setClickable(val);
        q102.setClickable(val);
        q103.setClickable(val);
        q104.setClickable(val);

        q41.setClickable(val);
        q42.setClickable(val);
        q43.setClickable(val);
        q44.setClickable(val);


        q2.setFocusable(val);

        q6.setFocusable(val);

        q9.setFocusable(val);

        spinner1.setEnabled(val);

        spinner2.setEnabled(val);

        q81.setClickable(val);
        q82.setClickable(val);
        q83.setClickable(val);
        q84.setClickable(val);

    }

    //    To Start Timer and set Question Scroll View to VISIBLE
    void play(long time) {

        done.setVisibility(View.INVISIBLE);

        setQuestionVisibility(View.VISIBLE);

//        if (!isTick) {
        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                leftTimeMiliS = millisUntilFinished;
                updateTime();
            }

            @Override
            public void onFinish() {
                isTick = false;
                playPause.setImageResource(R.drawable.ic_play_arrow_black_36dp);
                playPause.setVisibility(View.INVISIBLE);
                done.setVisibility(View.VISIBLE);
                Done();

            }
        }.start();

        playPause.setImageResource(R.drawable.ic_pause_black_36dp);
        isTick = true;

//        }

    }

    //    To pause the Timer and make Questions Scroll View To GONE
    void pause() {
        done.setVisibility(View.VISIBLE);


        setQuestionVisibility(View.GONE);

        startTimeMiliS = leftTimeMiliS;
        countDownTimer.cancel();
        isTick = false;
        playPause.setImageResource(R.drawable.ic_play_arrow_black_36dp);
    }

    //    To Update time of Timer
    void updateTime() {
        int min = (int) (leftTimeMiliS / 1000) / 60;
        int sec = (int) (leftTimeMiliS / 1000) % 60;

        timer.setText(String.format(Locale.getDefault(), "%02d:%02d", min, sec));
    }

    //    To Calculate The Grade Scored and Make Visible Text Which show Questions attemted or not Status
    void calculate() {

        String c = "Correct Answer";
        if (a1.getText() == attempted) {
            if (q13.isChecked()) {
                totalMarks += 1;
                a1.setText(c);
            } else {
                c1.setText(R.string.correct1);
                dc1.setVisibility(View.VISIBLE);
            }
        }

        if (a2.getText() == attempted) {
            if (q2.getText().toString().equals(getString(R.string.correct2))) {
                totalMarks += 2;
                a2.setText(c);
            } else {
                dc2.setVisibility(View.VISIBLE);
                c2.setText(R.string.correct2);
            }
        }

        if (a3.getText() == attempted) {
            if (q3.equals(getString(R.string.correct3))) {
                totalMarks += 1;
                a3.setText(c);
            } else {
                dc3.setVisibility(View.VISIBLE);
                c3.setText(R.string.correct3);
            }
        }

        if (a4.getText() == attempted) {
            if (q42.isChecked()) {
                totalMarks += 1;
                a4.setText(c);
            } else {
                dc4.setVisibility(View.VISIBLE);
                c4.setText(R.string.correct4);
            }
        }
        if (a5.getText() == attempted) {
            if (q5.equals(getString(R.string.correct5))) {
                totalMarks += 1;
                a5.setText(c);
            } else {
                dc5.setVisibility(View.VISIBLE);
                c5.setText(R.string.correct5);
            }
        }

        if (a6.getText() == attempted) {
            if (q6.getText().toString().matches(getString(R.string.correctedit6))) {
                totalMarks += 2;
                a6.setText(c);
            } else {
                dc6.setVisibility(View.VISIBLE);
                c6.setText(R.string.correctedit6);
            }
        }
        if (a7.getText() == attempted) {
            if (q72.isChecked()) {
                totalMarks += 1;
                a7.setText(c);
            } else {
                dc7.setVisibility(View.VISIBLE);
                c7.setText(R.string.correct7);
            }
        }
        if (a8.getText() == attempted) {
            if (q82.isChecked() && q83.isChecked() && !q81.isChecked() && !q84.isChecked()) {
                totalMarks += 3;
                a8.setText(c);
            } else {
                dc8.setVisibility(View.VISIBLE);
                c8.setText(R.string.correct8);
            }
        }
        if (a9.getText() == attempted) {
            if (q9.getText().toString().matches(getString(R.string.correctedit9))) {
                totalMarks += 2;
                a9.setText(c);
            } else {
                dc9.setVisibility(View.VISIBLE);
                c9.setText(R.string.correctedit9);
            }
        }
        if (a10.getText() == attempted) {
            if (q102.isChecked()) {
                totalMarks += 1;
                a10.setText(c);
            } else {
                dc10.setVisibility(View.VISIBLE);
                c10.setText(R.string.correct10);
            }
        }

        a1.setVisibility(View.VISIBLE);
        a2.setVisibility(View.VISIBLE);
        a3.setVisibility(View.VISIBLE);
        a4.setVisibility(View.VISIBLE);
        a5.setVisibility(View.VISIBLE);
        a6.setVisibility(View.VISIBLE);
        a7.setVisibility(View.VISIBLE);
        a8.setVisibility(View.VISIBLE);
        a9.setVisibility(View.VISIBLE);
        a10.setVisibility(View.VISIBLE);

    }

    //    To Set The Question Status : Attemped Or Not and Display correct answer of Attempted Question
    void attempted() {

        String notAttempted = "Not Attempted";
        a1.setText(notAttempted);
        a2.setText(notAttempted);
        a3.setText(notAttempted);
        a4.setText(notAttempted);
        a5.setText(notAttempted);
        a6.setText(notAttempted);
        a7.setText(notAttempted);
        a8.setText(notAttempted);
        a9.setText(notAttempted);
        a10.setText(notAttempted);

        if (q11.isChecked() || q12.isChecked() || q13.isChecked() || q14.isChecked()) {
            a1.setText(attempted);
        } else {
            c1.setText(R.string.correct1);
        }

        if (q41.isChecked() || q42.isChecked() || q43.isChecked() || q44.isChecked()) {
            a4.setText(attempted);
        } else {
            c4.setText(R.string.correct4);
        }

        if (q71.isChecked() || q72.isChecked() || q73.isChecked() || q74.isChecked()) {
            a7.setText(attempted);
        } else {
            c7.setText(R.string.correct7);
        }

        if (q101.isChecked() || q102.isChecked() || q103.isChecked() || q104.isChecked()) {
            a10.setText(attempted);
        } else {

            c10.setText(R.string.correct10);
        }

        if (!TextUtils.isEmpty(q2.getText().toString().trim())) {
            a2.setText(attempted);
        } else {
            c2.setText(R.string.correct2);
        }

        if (!TextUtils.isEmpty(q6.getText().toString().trim())) {
            a6.setText(attempted);
        } else {
            c6.setText(R.string.correctedit6);
        }

        if (!TextUtils.isEmpty(q9.getText().toString().trim())) {
            a9.setText(attempted);
        } else {
            c9.setText(R.string.correctedit9);
        }

        if (q81.isChecked() || q82.isChecked() || q83.isChecked() || q84.isChecked()) {
            a8.setText(attempted);
        } else {
            c8.setText(R.string.correct8);
        }

        if (spinner1.getSelectedItemPosition() != 0) {
            a3.setText(attempted);
        } else {
            c3.setText(R.string.correct3);
        }

        if (spinner2.getSelectedItemPosition() != 0) {
            a5.setText(attempted);
        } else {
            c5.setText(R.string.correct5);
        }

    }

    void exitDialog() {

    }

    //    To Show Alert Dialog With Passes insput as a message
//    @param String
    void dialogDone(String string) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle(string);

        alertDialog.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(QuizTest.this, QuizTest.class);
                startActivity(intent);
            }
        });

        alertDialog.setNegativeButton("Check Answer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialog.create();
        alertDialog.show();
    }

    //    To Start Back MainActivity
    void exit() {
        intent = new Intent(QuizTest.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Exit", true);
        startActivity(intent);
    }

    void showToast(String message) {

        if (toast != null) {
            toast.cancel();
            toast = null;
        }

        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();

    }

    void setQuestionVisibility(int val) {
        switch (val) {
            case View.VISIBLE:
                flipper.setVisibility(View.VISIBLE);
                headerLinearLayout.setLayoutParams(layoutParamsWrapHeight);
                questionNavigator.setVisibility(View.VISIBLE);
                break;

            case View.GONE:
                flipper.setVisibility(View.GONE);
                headerLinearLayout.setLayoutParams(layoutParamsFullHeight);
                questionNavigator.setVisibility(View.GONE);
                break;
        }
    }

    void loadNextQuestion() {
        if (quesNumber < 9) {
            flipper.showNext();
            quesNumber++;
        } else {
            showToast("Last Question");
        }
    }

    void loadPreviousQuestion() {
        if (quesNumber > 0) {
            flipper.showPrevious();
            quesNumber--;
        } else {
            showToast("First Question");
        }
    }

}