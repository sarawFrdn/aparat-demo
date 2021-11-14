package com.androidlearn.aparat.webservice;

import android.util.Log;

import com.androidlearn.aparat.models.Category;
import com.androidlearn.aparat.models.IResponseListener;
import com.androidlearn.aparat.models.News;
import com.androidlearn.aparat.models.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    IService iService;

public  WebserviceCaller(){

    iService = ApiClient.getClient().create(IService.class);

}

public void getNewVideos(IResponseListener listener){

    Call<List<Video>> call = iService.getNewVideos();
    call.enqueue(new Callback<List<Video>>() {
        @Override
        public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {

            listener.onSuccess(response.body());
        }

        @Override
        public void onFailure(Call<List<Video>> call, Throwable t) {

            listener.onFailure(t.getMessage().toString());
        }
    });


}
    public void getBestVideos(IResponseListener listener) {

        Call<List<Video>> call = iService.getBestVideo();
        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {

                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {

                listener.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSpecialVideos(IResponseListener listener) {

        Call<List<Video>> call = iService.getSpecialVideo();
        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {

                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {

                listener.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getCategory(IResponseListener listener){

    Call<List<Category>> call = iService.getCategory();
    call.enqueue(new Callback<List<Category>>() {
        @Override
        public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
            listener.onSuccess(response.body());
        }

        @Override
        public void onFailure(Call<List<Category>> call, Throwable t) {
           listener.onFailure(t.getMessage().toString());
        }
    });
    }


    public void getNews(IResponseListener listener){

       Call<List<News>> call = iService.getNews();
       call.enqueue(new Callback<List<News>>() {
           @Override
           public void onResponse(Call<List<News>> call, Response<List<News>> response) {
               listener.onSuccess(response.body());
           }

           @Override
           public void onFailure(Call<List<News>> call, Throwable t) {
               listener.onFailure(t.getMessage().toString());

           }
       });


    }


}
