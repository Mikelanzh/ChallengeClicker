package com.example.sowl.challengeclicker.Activitys;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sowl.challengeclicker.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // UI
    RelativeLayout mRelativeLayout;
    Button mButton, mResetbutton;
    TextView txt_score, txt_finalscore;
    TextView txt_timer;
    boolean game_finish = false;

    // params
    int counter = 0;
    int[] rainbow;
    int colorA = 0, colorB = 0, colorC = 0;
    int A, B, C;

    // methods
    CountDownTimer cot = new CountDownTimer(30000, 1000) {


        public void onTick(long millisUntilFinished) {
            txt_timer.setText("seconds remaining: " + millisUntilFinished / 1000);
            //here you can have your logic to set text to edittext

        }

        public void onFinish() {
            txt_timer.setText("done!");
            mButton.setVisibility(View.GONE);
            txt_finalscore.setVisibility(View.VISIBLE);
            txt_finalscore.setText("Your Final Score is " + String.valueOf(counter - 1));
            txt_score.setVisibility(View.GONE);
            mResetbutton.setY((mRelativeLayout.getHeight() / 2) + txt_finalscore.getHeight());
            mResetbutton.setVisibility(View.VISIBLE);
            colortimer.cancel();
            counter = 0;

        }

    };

    CountDownTimer colortimer = new CountDownTimer(30000, 35) {


        public void onTick(long millisUntilFinished) {

            //here you can have your logic to set text to edittext

            if (colorA >= 252)
                A = -3;

            if (colorA <= 0)
                A = 1;

            if (colorB >= 252)
                B = -1;

            if (colorB <= 0)
                B = 2;

            if (colorC >= 252)
                C = -3;

            if (colorC <= 0)
                C = 2;

            colorC += C;
            colorA += A;
            colorB += B;
            int colorToSet = Color.argb(255, colorA, colorB, colorC);
            mRelativeLayout.setBackgroundColor(colorToSet);
            //mButton.getBackground().setAlpha(A);


        }

        public void onFinish() {

            colorC = 0;
            colorB = 0;
            colorA = 255;

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_score = (TextView) findViewById(R.id.Scoretext);
        txt_timer = (TextView) findViewById(R.id.Timer_txt);
        txt_finalscore = (TextView) findViewById(R.id.Final_score_txt);
        rainbow = getResources().getIntArray(R.array.Shades);
        mButton = (Button) findViewById(R.id.button_rnd_dynamic);
        mResetbutton = (Button) findViewById(R.id.reset_btn);
        mButton.setOnClickListener(this);
        mResetbutton.setOnClickListener(this);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout_container);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reset_btn:
                addRndButton();
                break;

            case R.id.button_rnd_dynamic:
                addRndButton();
                break;
        }
    }

    private void addRndButton() {
        if (counter == 0) {
            cot.start();
            colortimer.start();
            txt_score.setVisibility(View.VISIBLE);
            mResetbutton.setVisibility(View.GONE);
            mButton.setVisibility(View.VISIBLE);
            txt_finalscore.setVisibility(View.GONE);
            mRelativeLayout.setBackgroundColor(Color.parseColor("#cdf5e1"));
        }
        int width = mRelativeLayout.getWidth();
        int height = mRelativeLayout.getHeight();

        Random r = new Random();
        mButton.setX(r.nextInt(width - mButton.getWidth()));
        mButton.setY(r.nextInt(height - mButton.getHeight()));

        mRelativeLayout.removeAllViews();
        mRelativeLayout.addView(mButton);
        mRelativeLayout.addView(txt_finalscore);
        mRelativeLayout.addView(mResetbutton);
        txt_score.setText(String.valueOf(counter++));


        mButton.setText("Click Me!");
    }
}
