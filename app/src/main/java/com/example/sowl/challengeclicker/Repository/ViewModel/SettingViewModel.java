package com.example.sowl.challengeclicker.Repository.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.sowl.challengeclicker.Repository.Model.PlayerSubmitRespone;
import com.example.sowl.challengeclicker.Repository.Network.WebProvider;
import com.example.sowl.challengeclicker.Repository.Repo.Repo;

import io.reactivex.Observable;
import okhttp3.MultipartBody;

public class SettingViewModel extends ViewModel {

    Repo repo = new Repo(WebProvider.getWebService());


    public Observable<PlayerSubmitRespone> AddPlayer(MultipartBody.Part[] imageFile, String name) {
        return repo.AddPlayer(imageFile, name);
    }


}
