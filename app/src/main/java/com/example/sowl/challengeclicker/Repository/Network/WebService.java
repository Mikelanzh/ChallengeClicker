package com.example.sowl.challengeclicker.Repository.Network;

import com.example.sowl.challengeclicker.Repository.Model.ApiResponse;
import com.example.sowl.challengeclicker.Repository.Model.Callers;
import com.example.sowl.challengeclicker.Repository.Model.PlayerSubmitRespone;
import com.example.sowl.challengeclicker.Repository.Model.ResponceScore;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface WebService {

//    @GET("reverse")
//    Call<NeshanMap> get_Reverse_GEO(@Header("WebService-Key") String Api_Key, @Query("lat") double lat, @Query("lng") double lng);

    @GET("api/GetScores")
    Observable<ResponceScore> GetScores();

    @POST("api/SendScores")
    Observable<ApiResponse> SendScores(@Body Callers callers);


//    @POST("api/SubmitPlayer")
//    Observable<PlayerSubmitRespone> SubmitPlayer(@Body Player player);


    @Multipart
    @POST("api/SubmitPlayer")
    Observable<PlayerSubmitRespone> AddPlayer(@Part MultipartBody.Part[] imageFile, @Header("PlayerName") String name);


//    @Multipart
//    @POST("/upload")
//    Observable<ApiResponse> uploadImage(@Part MultipartBody.Part file, @Part("Avatar") RequestBody requestBody);

//
//    @POST("api/SearchMabda")
//    Observable<StatusResponce> getMabdasBySearch(@Header("MyCustomID") String header, @Body SearchMabda searchMabda);


}