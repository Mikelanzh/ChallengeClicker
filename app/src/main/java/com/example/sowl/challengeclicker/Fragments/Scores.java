package com.example.sowl.challengeclicker.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sowl.challengeclicker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Scores extends Fragment {

    private RecyclerView mRecycler;
    private NavController navController;
    private ImageButton mBtnBack;


    public Scores() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scores, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        initListener();
    }

    private void init(View view) {

        mBtnBack = view.findViewById(R.id.BtnBack);
        navController = NavHostFragment.findNavController(this);
        mRecycler = view.findViewById(R.id.champs_card_recycler);

    }

    private void initListener() {
        mBtnBack.setOnClickListener(view -> {
            navController.navigate(R.id.gameFragment);
        });
    }


}
