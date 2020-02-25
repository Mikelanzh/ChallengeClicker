package com.example.sowl.challengeclicker.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sowl.challengeclicker.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Setting extends Fragment {

    private NavController navController;
    private CircleImageView mAvatar;
    private EditText mNameEntering;
    private Button mBtn;


    public Setting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        init(view);
        initListener();
    }

    private void init(View view) {

        mAvatar = view.findViewById(R.id.profile_image);
        mNameEntering = view.findViewById(R.id.EnteringNameED);
        mBtn = view.findViewById(R.id.BtnSubmit);
        navController = NavHostFragment.findNavController(this);


    }

    private void initListener() {

        mBtn.setOnClickListener(view -> {

            navController.navigate(R.id.gameFragment);


        });

    }

}
