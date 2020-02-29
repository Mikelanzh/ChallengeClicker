package com.example.sowl.challengeclicker.Repository.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.sowl.challengeclicker.Repository.Model.ApiResponse;
import com.example.sowl.challengeclicker.Repository.Model.Callers;
import com.example.sowl.challengeclicker.Repository.Model.ResponceScore;
import com.example.sowl.challengeclicker.Repository.Network.WebProvider;
import com.example.sowl.challengeclicker.Repository.Repo.Repo;

import io.reactivex.Observable;

public class ScoreViewModel extends ViewModel {
    Repo repo = new Repo(WebProvider.getWebService());


    public Observable<ResponceScore> GetScores() {
        return repo.GetScores();
    }

    public Observable<ApiResponse> SendScores(Callers callers) {
        return repo.SendScores(callers);
    }
}
