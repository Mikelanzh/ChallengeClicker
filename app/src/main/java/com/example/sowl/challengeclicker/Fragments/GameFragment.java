package com.example.sowl.challengeclicker.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sowl.challengeclicker.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {


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
    private ImageButton mBtnSetting;
    private ImageButton mTopScores;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        init(view);
        initListener();
    }

    private void init(View view) {

        navController = NavHostFragment.findNavController(this);
        txt_score = view.findViewById(R.id.Scoretext);
        txt_timer = view.findViewById(R.id.Timer_txt);
        txt_finalscore = view.findViewById(R.id.Final_score_txt);
        rainbow = getResources().getIntArray(R.array.Shades);
        mButton = view.findViewById(R.id.button_rnd_dynamic);
        mResetbutton = view.findViewById(R.id.reset_btn);
//        mButton.setOnClickListener(this);
//        mResetbutton.setOnClickListener(this);
        mRelativeLayout = view.findViewById(R.id.RelativeLayout_container);
        mBtnSetting = view.findViewById(R.id.setting);
        mTopScores = view.findViewById(R.id.topScores);
    }

    private void initListener() {

        mButton.setOnClickListener(view -> {
            addRndButton();
        });

        mResetbutton.setOnClickListener(view -> {
            addRndButton();
        });

        mBtnSetting.setOnClickListener(view -> {
            navController.navigate(R.id.action_gameFragment2_to_setting2);
        });

        mTopScores.setOnClickListener(view -> {
            navController.navigate(R.id.action_gameFragment_to_scores);
        });
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
