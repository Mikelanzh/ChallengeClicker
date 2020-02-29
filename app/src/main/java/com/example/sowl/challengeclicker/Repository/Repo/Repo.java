package com.example.sowl.challengeclicker.Repository.Repo;

import com.example.sowl.challengeclicker.Repository.Model.ApiResponse;
import com.example.sowl.challengeclicker.Repository.Model.Callers;
import com.example.sowl.challengeclicker.Repository.Model.PlayerSubmitRespone;
import com.example.sowl.challengeclicker.Repository.Model.ResponceScore;
import com.example.sowl.challengeclicker.Repository.Network.WebService;

import io.reactivex.Observable;
import okhttp3.MultipartBody;

public class Repo {

    WebService webService;


    public Repo(WebService webService) {
        this.webService = webService;
    }

    public Observable<ResponceScore> GetScores() {
        return webService.GetScores();
    }

    public Observable<ApiResponse> SendScores(Callers callers) {
        return webService.SendScores(callers);
    }

    public Observable<PlayerSubmitRespone> AddPlayer(MultipartBody.Part[] imageFile, String name) {
        return webService.AddPlayer(imageFile, name);
    }


//    public Observable<ApiResponse> getDamsBySearch(String header, SearchAbro searchAbro) {
//        return webService.getDamsBySearch(header, searchAbro);
//    }


}