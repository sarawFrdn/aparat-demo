package com.androidlearn.aparat.webservice;

import com.androidlearn.aparat.models.Category;
import com.androidlearn.aparat.models.News;
import com.androidlearn.aparat.models.Video;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IService {

    @GET("getBestVideos.php")
    Call<List<Video>> getBestVideo();

    @GET("getSpecial.php")
    Call<List<Video>> getSpecialVideo();

    @GET("getNewVideos.php")
    Call<List<Video>> getNewVideos();

    @POST("login.php")
    @FormUrlEncoded
    Call<ResponseBody> login(@Field("username") String user, @Field("password") String pass);

    @POST("register.php")
    @FormUrlEncoded
    Call<ResponseBody> register(@Field("username") String user, @Field("password") String pass);

    @GET("getCategory.php")
    Call<List<Category>> getCategory();

    @GET("getNews.php")
    Call<List<News>> getNews();


}
